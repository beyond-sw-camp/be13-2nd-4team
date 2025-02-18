package com.beyond.backend.service.impl;

import com.beyond.backend.data.dto.TeamDto;
import com.beyond.backend.data.dto.TeamResponseDto;
import com.beyond.backend.data.dto.TeamSearchDto;
import com.beyond.backend.data.entity.Team;
import com.beyond.backend.data.repository.TeamRepository;
import com.beyond.backend.service.TeamService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
     *
     * @param userNo 유저 번호
     * @return TeamResponseDto teamResponseDto
     */
    @Override
    public List<TeamSearchDto> filterUserTeams(Long userNo, String teamName, String teamIntroduce, String projectStatus){
        List<TeamSearchDto> teams = teamRepository.findUserTeams(userNo);

        List<TeamSearchDto> filteredTeams = teams.stream()
                .filter(team -> teamName == null || team.getTeamName().contains(teamName))
                .filter(team -> teamIntroduce == null || team.getTeamIntroduce().contains(teamIntroduce))
                .filter(team -> projectStatus == null || team.getProjectStatus().equals(projectStatus))
                .toList();
        return filteredTeams;
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
