package com.beyond.backend.service.impl;

import com.beyond.backend.data.dto.TeamDto;
import com.beyond.backend.data.dto.TeamResponseDto;
import com.beyond.backend.data.dto.TeamSearchDto;
import com.beyond.backend.data.entity.Team;
import com.beyond.backend.data.repository.TeamRepository;
import com.beyond.backend.service.TeamService;
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
 */
@Service
public class TeamServiceImpl implements TeamService {

    private final TeamRepository teamRepository;

    /**
     * TeamServiceImpl 생성자
     * @param teamRepository 팀 Repository
     * @see TeamRepository
     */
    @Autowired
    public TeamServiceImpl(TeamRepository teamRepository) {
        this.teamRepository = teamRepository;
    }

    /**
     * 팀 생성
     *
     * @param teamDto 팀 생성
     * @return
     */
    @Override
    public TeamResponseDto createTeam(TeamDto teamDto) {
        Team team = new Team();
       // team.setName(teamDto.getName());
       // team.setGoal(teamDto.getGoal());
       // team.setLeaderid(teamDto.getLeaderid());

        Team createTeam = teamRepository.save(team);

        TeamResponseDto  teamResponseDto = new TeamResponseDto();
//        teamResponseDto.setName(createTeam.getName());
//        teamResponseDto.setGoal(createTeam.getGoal());
//        teamResponseDto.setLeaderid(createTeam.getLeaderid());

        return teamResponseDto;
    }

    /**
     * 팀 정보 수정
     *
     * @param team 팀 정보
     * @return TeamDto TeamDto
     */
    @Override
    public TeamDto updateTeam(TeamDto team) {
        return TeamDto.builder()
                .teamName(team.getTeamName())
                .teamIntroduce(team.getTeamIntroduce())
                .projectStatus(team.getProjectStatus())
                .build();
    }

    /**
     * userNo로 팀 정보 조회 서비스
     *
     * @param userNo 유저 번호
     * @param teamName (필터) 팀이름
     * @param teamIntroduce (필터) 팀 설명
     * @param projectStatus (필터) 팀 상태
     * @param page 최소 출력 값
     * @param size 최대 출력 값
     * @return PageImpl 필터링 결과값 반환
     */
    @Override
    public Page<TeamSearchDto> filterUserTeams(
            Long userNo, String teamName, String teamIntroduce, String projectStatus, int page, int size){
        Pageable pageable = PageRequest.of(page, size);
        Page<TeamSearchDto> teams = teamRepository.findUserTeams(userNo, pageable);

        List<TeamSearchDto> filteredTeams = teams.stream()
                .filter(team -> teamName == null || team.getTeamName().contains(teamName))
                .filter(team -> teamIntroduce == null || team.getTeamIntroduce().contains(teamIntroduce))
                .filter(team -> projectStatus == null || team.getProjectStatus().equals(projectStatus))
                .toList();
        return new PageImpl<>(filteredTeams, pageable, teams.getTotalElements());
    }

    /**
     * 팀 삭제
     * @param id 팀 ID
     * @throws Exception
     */
    @Override
    public void deleteTeam(Long id) throws Exception {
        teamRepository.deleteById(id);
    }
}
