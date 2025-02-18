package com.beyond.backend.service;

import com.beyond.backend.data.dto.TeamDto;
import com.beyond.backend.data.dto.TeamResponseDto;
import com.beyond.backend.data.dto.TeamSearchDto;
import org.springframework.data.domain.Page;

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
 * 2025-02-18        hongjm           팀 검색 페이징 기능 추가 및 보완
 */

public interface TeamService {
    TeamResponseDto createTeam(TeamDto team);

    TeamResponseDto updateTeam(TeamResponseDto team);

    Page<TeamSearchDto> filterUserTeams(
            Long userNo, String teamName, String teamIntroduce, String projectStatus, int page, int size);

    void deleteTeam(Long id) throws Exception;


}
