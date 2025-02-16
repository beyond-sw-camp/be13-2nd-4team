package com.beyond.backend.service.impl;

import com.beyond.backend.data.dto.TeamDto;
import com.beyond.backend.data.dto.TeamResponseDto;
import com.beyond.backend.data.entity.Team;
import com.beyond.backend.data.entity.TeamUser;
import com.beyond.backend.data.repository.TeamRepository;
import com.beyond.backend.data.repository.TeamUserRepository;
import com.beyond.backend.service.TeamService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * <p>
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
 * 2025-02-16        hongjm           팀 조회 기능 추가 및 정리
 */
@Service
public class TeamServiceImpl implements TeamService {

    private final TeamRepository teamRepository;
    private final TeamUserRepository teamUserRepository;

    /**
     * TeamServiceImpl 생성자
     * @param teamRepository 팀 Repository
     * @see TeamRepository
     * @see TeamUserRepository
     */
    @Autowired
    public TeamServiceImpl(TeamRepository teamRepository, TeamUserRepository teamUserRepository) {
        this.teamRepository = teamRepository;
        this.teamUserRepository = teamUserRepository;
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
//        team.setName(teamDto.getName());
//        team.setGoal(teamDto.getGoal());
//        team.setLeaderid(teamDto.getLeaderid());

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
     * @return TeamResponseDto teamResponseDto
     */
    @Override
    public TeamResponseDto updateTeam(TeamResponseDto team) {
        TeamResponseDto teamResponseDto = new TeamResponseDto();
//        teamResponseDto.setId(team.getId());
//        teamResponseDto.setName(team.getName());
//        teamResponseDto.setGoal(team.getGoal());
//        teamResponseDto.setLeaderid(team.getLeaderid());

        return teamResponseDto;
    }

    /**
     * 팀 정보 조회
     * @param userNo 유저 번호
     * @return TeamResponseDto teamResponseDto
     */
    @Override
    public List<Team> findTeamsByUserNo(Long userNo) {
        List<TeamUser> teamUser = teamUserRepository.findByUserNo(userNo);
        List<Team> teams = new ArrayList<>();
        
        // 해당되는 모든 팀을 가져와서 팀 리스트에 넣어 반환
        for(TeamUser team : teamUser) {
            teams.add(team.getTeam());
        }
        return teams;
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
