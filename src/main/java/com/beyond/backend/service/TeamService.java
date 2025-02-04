package com.beyond.backend.service;

import com.beyond.backend.data.dto.TeamDto;
import com.beyond.backend.data.dto.TeamResponseDto;
import com.beyond.backend.data.entity.Team;

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

    TeamResponseDto updateTeam(TeamResponseDto team);

    TeamResponseDto getTeam(Long id);

    void deleteTeam(int id);
}
