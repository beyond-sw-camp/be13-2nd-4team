package com.beyond.backend.service;

import com.beyond.backend.data.dto.TeamDto;
import com.beyond.backend.data.dto.TeamResponseDto;
import com.beyond.backend.data.entity.Team;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

/**
 * <p>
 *
 * <p>packageName    : com.beyond.backend.service
 * <p>fileName       : TeamService
 * <p>author         : hongjm
 * <p>date           : 2025-02-03
 * <p>description    :
 */
/*
 * ===========================================================
 * DATE              AUTHOR             NOTE
 * -----------------------------------------------------------
 * 2025-02-03        hongjm           최초 생성
 * 2025-02-15        hongjm           팀 검색 기능 추가
 */

public interface TeamService {
    TeamResponseDto createTeam(TeamDto team);

    TeamResponseDto updateTeam(TeamResponseDto team);

    @Query("SELECT tu.team.no FROM TeamUser tu WHERE tu.user.no = :userNo")
    List<Team> findTeamsByUserNo(@Param("userNo")Long userNo);

    void deleteTeam(Long id) throws Exception;
}
