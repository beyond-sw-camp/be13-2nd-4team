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

    /**
     * 팀 정보 수정
     *
     * @param team 팀 정보
     * @return TeamResponseDto teamResponseDto
     */
    @Override
    public TeamResponseDto updateTeam(TeamResponseDto team) {
        TeamResponseDto teamResponseDto = new TeamResponseDto();
        teamResponseDto.setId(team.getId());
        teamResponseDto.setName(team.getName());
        teamResponseDto.setGoal(team.getGoal());
        teamResponseDto.setLeaderid(team.getLeaderid());

        return teamResponseDto;
    }

    /**
     * 팀 정보 조회
     * @param id 팀 ID
     * @return TeamResponseDto teamResponseDto
     */
    @Override
    public TeamResponseDto getTeam(Long id) {
        Team team = teamRepository.findById(id).get();

        TeamResponseDto teamResponseDto = new TeamResponseDto();
        teamResponseDto.setName(team.getName());
        teamResponseDto.setGoal(team.getGoal());
        teamResponseDto.setLeaderid(team.getLeaderid());

        return teamResponseDto;
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
