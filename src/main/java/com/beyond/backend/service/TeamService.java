package com.beyond.backend.service;

import com.beyond.backend.data.dto.TeamDto;
import com.beyond.backend.data.dto.TeamResponseDto;

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
 */

public interface TeamService {
    TeamResponseDto createTeam(TeamDto team);

    TeamDto updateTeam(TeamDto team);

    TeamDto getTeamById(Long id);

    void deleteTeam(Long id) throws Exception;
}
