package com.beyond.backend.service.impl;

import com.beyond.backend.data.dto.TeamDto;
import com.beyond.backend.data.dto.TeamResponseDto;
import com.beyond.backend.data.entity.Team;
import com.beyond.backend.data.repository.TeamRepository;
import com.beyond.backend.service.TeamService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 
 * <p>packageName    : com.beyond.backend.service.impl
 * <p>fileName       : TeamServiceImpl
 * <p>author         : hongjm
 * <p>date           : 2025-02-03
 * <p>description    : 
 */
 /*
 * ===========================================================
 * DATE              AUTHOR             NOTE
 * -----------------------------------------------------------
 * 2025-02-03        hongjm           최초 생성
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
        team.setName(teamDto.getName());
        team.setGoal(teamDto.getGoal());
        team.setLeaderid(teamDto.getLeaderid());

        Team createTeam = teamRepository.save(team);

        TeamResponseDto  teamResponseDto = new TeamResponseDto();
        teamResponseDto.setName(createTeam.getName());
        teamResponseDto.setGoal(createTeam.getGoal());
        teamResponseDto.setLeaderid(createTeam.getLeaderid());

        return teamResponseDto;
    }

    @Override
    public TeamDto updateTeam(TeamDto team) {
        return null;
    }

    @Override
    public TeamDto getTeamById(Long id) {
        return null;
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
