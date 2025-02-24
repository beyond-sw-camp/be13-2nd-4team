package com.beyond.backend.service.impl;

import com.beyond.backend.data.dto.teamDto.TeamDto;
import com.beyond.backend.data.dto.teamDto.TeamMemberListDto;
import com.beyond.backend.data.dto.teamDto.TeamResponseDto;
import com.beyond.backend.data.entity.ProjectStatus;
import com.beyond.backend.data.entity.TeamUser;
import com.beyond.backend.data.entity.TimePeriod;
import com.beyond.backend.data.entity.User;
import com.beyond.backend.data.repository.TeamRepository;
import com.beyond.backend.data.repository.TeamUserRepository;
import com.beyond.backend.data.repository.UserRepository;
import com.beyond.backend.service.TeamService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * <p> 팀 서비스 상세
 * 
 * <p>packageName    : com.beyond.backend.service.impl
 * <p>fileName       : TeamServiceImpl
 * <p>author         : hongjm
 * <p>date           : 2025-02-03
 * <p>description    : Team 관련 ServiceImpl
 */
 /*
 * ===========================================================
 * DATE              AUTHOR             NOTE
 * -----------------------------------------------------------
 * 2025-02-03        hongjm           최초 생성
 * 2025-02-18        hongjm           팀 조회 기능 추가 및 정리
 * 2025-02-20        hongjm           팀 CRUD 정리 및 수정
 * 2025-02-22        hongjm           팀원 추가/제거 등등 기능 추가
 * 2025-02-23        hongjm           기능 추가 및 코드 정리
 */
@Slf4j
@Service
public class TeamServiceImpl implements TeamService {

    private final TeamRepository teamRepository;
    private final UserRepository userRepository;
    private final TeamUserRepository teamUserRepository;

    /**
     * TeamServiceImpl 생성자
     *
     * @param teamRepository     팀 Repository
     * @param userRepository     유저 Repository
     * @param teamUserRepository 팀-유저 중간 Repository
     * @see TeamRepository
     */
    @Autowired
    public TeamServiceImpl(TeamRepository teamRepository, UserRepository userRepository, TeamUserRepository teamUserRepository) {
        this.teamRepository = teamRepository;
        this.userRepository = userRepository;
        this.teamUserRepository = teamUserRepository;
    }

    /* 팀 전체 페이지 페이지*/
    /* 기본적인 CRUD */

    /**
     * 팀 생성
     *
     * @param teamDto 팀 생성 정보
     * @return teamResponseDto
     */
    @Override
    public TeamResponseDto createTeam(TeamDto teamDto) {
        User user = userRepository.findById(teamDto.getNo())
                .orElseThrow(() -> new IllegalArgumentException("유저가 존재하지 않습니다."));

        // 팀 저장
        com.beyond.backend.data.entity.Team team = com.beyond.backend.data.entity.Team.builder()
                .teamName(teamDto.getTeamName())
                .teamIntroduce(teamDto.getTeamIntroduce())
                .projectStatus(teamDto.getProjectStatus())
                .timePeriod(new TimePeriod())
                .build();
        team = teamRepository.save(team);

        // TeamUser 저장
        TeamUser teamUser = TeamUser.builder()
                .user(user)
                .team(team)
                .status(true)
                .isLeader(true)
                .build();
        teamUserRepository.save(teamUser);

        TeamResponseDto teamResponseDto = new TeamResponseDto(
                team.getNo(),
                team.getTeamName(),
                team.getTeamIntroduce(),
                team.getProjectStatus(),
                team.getTimePeriod()
        );

        return teamResponseDto;
    }

    /**
     * 팀 정보 수정
     *
     * @param teamDto 팀 정보
     * @return TeamResponseDto
     * @throws Exception 팀을 찾을 수 없습니다.
     */
    @Override
    public TeamResponseDto updateTeam(TeamDto teamDto) throws Exception {

        com.beyond.backend.data.entity.Team searchTeam = teamRepository.findById(teamDto.getNo())
                .orElseThrow(() -> new Exception("팀을 찾을 수 없습니다."));

        searchTeam.updateTeamDetails(
                teamDto.getTeamName(),
                teamDto.getTeamIntroduce(),
                teamDto.getProjectStatus(),
                new TimePeriod()
        );

        com.beyond.backend.data.entity.Team updateTeam = teamRepository.save(searchTeam);

        return new TeamResponseDto(
                updateTeam.getNo(),
                updateTeam.getTeamName(),
                updateTeam.getTeamIntroduce(),
                updateTeam.getProjectStatus(),
                updateTeam.getTimePeriod()
        );
    }

    /**
     * 모든 팀 정보 조회
     * @param teamName      (필터) 팀 이름
     * @param teamIntroduce (필터) 팀 상세
     * @param projectStatus (필터) 팀 상태
     * @param page          최소 출력 값
     * @param size          최대 출력 값
     * @return PageImpl     필터링 결과값 반환
     */
    public PageImpl<TeamResponseDto> allUserTeams(
            String teamName, String teamIntroduce, ProjectStatus projectStatus, int page, int size) {
        Pageable pageable = PageRequest.of(page, size);
        Page<TeamResponseDto> teams = teamUserRepository.findByStatusForTeams(projectStatus, pageable);

        List<TeamResponseDto> filteredTeams = teams.stream()
                .filter(team -> teamName == null || team.getTeamName().contains(teamName))
                .filter(team -> teamIntroduce == null || team.getTeamIntroduce().contains(teamIntroduce))
                .filter(team -> projectStatus == null || team.getProjectStatus().equals(projectStatus))
                .toList();

        return new PageImpl<>(filteredTeams, pageable, teams.getTotalElements());
    }

    /**
     * userNo로 팀 정보 조회 서비스
     *
     * @param userNo        유저 번호
     * @param teamName      (필터) 팀이름
     * @param teamIntroduce (필터) 팀 설명
     * @param projectStatus (필터) 팀 상태
     * @param page          최소 출력 값
     * @param size          최대 출력 값
     * @return PageImpl 필터링 결과값 반환
     */
    @Override
    public PageImpl<TeamResponseDto> filterUserTeams(
            Long userNo, String teamName, String teamIntroduce, ProjectStatus projectStatus, int page, int size) {
        Pageable pageable = PageRequest.of(page, size);
        Page<TeamResponseDto> teams = teamUserRepository.findByUserNoForUserTeams(userNo, pageable);

        List<TeamResponseDto> filteredTeams = teams.stream()
                .filter(team -> teamName == null || team.getTeamName().contains(teamName))
                .filter(team -> teamIntroduce == null || team.getTeamIntroduce().contains(teamIntroduce))
                .filter(team -> projectStatus == null || team.getProjectStatus().equals(projectStatus))
                .toList();
        return new PageImpl<>(filteredTeams, pageable, teams.getTotalElements());
    }

    /**
     * 팀 삭제
     *
     * @param no 팀 ID
     * @throws Exception 팀이 존재하지 않습니다.
     */
    @Override
    public void deleteTeam(Long no) throws Exception {
        com.beyond.backend.data.entity.Team searchTeam = teamRepository.findById(no)
                .orElseThrow(() -> new Exception("팀이 존재하지 않습니다."));

        teamRepository.deleteById(no);
    }

    /* --------- 팀 디테일 페이지 ----------*/

    /**
     * 팀원 목록 조회 서비스
     *
     * @param teamNo 팀번호
     * @return TeamMemberListDto
     * @throws Exception 팀이 존재하지 않습니다.
     */
    @Override
    public List<TeamMemberListDto> getTeamMembers(Long teamNo) throws Exception {
        teamRepository.findById(teamNo)
                .orElseThrow(() -> new IllegalArgumentException("팀이 존재하지 않습니다."));

        return teamUserRepository.findByTeamNoForNonLeader(teamNo);
    }

    /**
     * [팀장] 팀원 신청 목록 조회
     *
     * @param teamNo 팀번호
     * @param userNo 유저번호
     * @return TeamMemberListDto
     * @throws Exception 권한이 없습니다!
     */
    @Override
    public List<TeamMemberListDto> getTeamMemberRequest(Long teamNo, Long userNo) throws Exception {
        Boolean isLeader = teamUserRepository.isLeader(teamNo, userNo);
        if (isLeader != null && isLeader) {
            return teamUserRepository.findByTeamNoForMemberRequest(teamNo);
        } else {
            throw new IllegalArgumentException("권한이 없습니다!");
        }
    }

    /**
     * [팀장] 팀원 신청 수락
     * @param teamNo 팀번호
     * @param userNo 신청한 유저의 유저번호
     * @throws Exception 신청한 유저가 없습니다!
     * @throws Exception 이미 가입된 유저입니다!
     */
    @Override
    public void teamAccept(Long teamNo, Long userNo) throws Exception {
        Long teamUserNo = teamUserRepository.findByUserNoForTeamUserNo(teamNo, userNo);

        TeamUser teamUser = teamUserRepository.findById(teamUserNo)
                .orElseThrow(() -> new IllegalArgumentException("신청한 유저가 없습니다!"));

        boolean status = teamUser.isStatus();
        if (status) {
            throw new IllegalArgumentException("이미 가입된 유저입니다!");
        }else {
            teamUser.setStatus(true);
            teamUserRepository.save(teamUser);
        }
    }

    /**
     * [팀장] 팀원 신청 거부
     * @param teamNo 팀번호
     * @param userNo 신청한 유저의 유저번호
     * @throws Exception 신청한 유저가 없습니다!
     */
    @Override
    public void teamDelete(Long teamNo, Long userNo) throws Exception {
        Long teamUserNo = teamUserRepository.findByUserNoForTeamUserNo(teamNo, userNo);

        TeamUser teamUser = teamUserRepository.findById(teamUserNo)
                .orElseThrow(() -> new IllegalArgumentException("신청한 유저가 없습니다!"));

        boolean status = teamUser.isStatus();
        if (!status) {
            teamUserRepository.deleteById(teamUserNo);
        }
        // 추방도 가능하지만 일방적인 추방 기능은 논의해봐야할듯
        // 현재는 유저 스스로 나가는것만 가능
    }

    /**
     * 팀원 신청
     *
     * @param teamNo 팀번호
     * @param userNo 유저번호
     * @throws Exception 팀이 존재하지 않습니다.
     * @throws Exception 유저가 존재하지 않습니다.
     * @throws Exception 모집중이 아닙니다!
     * @throws Exception 이미 등록되었거나 요청한 팀 입니다!!
     */
    @Override
    public void teamJoinRequest(Long teamNo, Long userNo) throws Exception {

        if (teamUserRepository.findByUserNoEquals(teamNo, userNo)) {
            throw new IllegalArgumentException("이미 등록되었거나 요청한 팀 입니다!!");
        }

        com.beyond.backend.data.entity.Team Team = teamRepository.findById(teamNo)
                .orElseThrow(() -> new IllegalArgumentException("팀이 존재하지 않습니다."));
        User user = userRepository.findById(userNo)
                .orElseThrow(() -> new IllegalArgumentException("유저가 존재하지 않습니다."));

        if (Team.getProjectStatus() != ProjectStatus.OPEN) {
            throw new IllegalArgumentException("모집중이 아닙니다!");
        }

        TeamUser teamUser = TeamUser.builder()
                .user(user)
                .team(Team)
                .status(false)
                .isLeader(false)
                .build();
        teamUserRepository.save(teamUser);
    }

    /**
     * 팀원 취소
     * @param teamNo 팀번호
     * @param userNo 유저번호
     * @throws Exception 신청하지 않았거나 존재하지 않는 팀입니다.
     */
    @Override
    public void teamJoinRequestCancel(Long teamNo, Long userNo) throws Exception {
        Long teamUserNo = teamUserRepository.findByUserNoForTeamUserNo(teamNo, userNo);
        if (teamUserNo == null) {
            throw new IllegalArgumentException("신청하지 않았거나 존재하지 않는 팀입니다.");
        } else {
            teamUserRepository.deleteById(teamUserNo);
        }
    }
}
