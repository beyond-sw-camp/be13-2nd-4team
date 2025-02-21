package com.beyond.backend.service;

import com.beyond.backend.data.dto.TeamDto;
import com.beyond.backend.data.dto.TeamResponseDto;
import com.beyond.backend.data.dto.TeamSearchDto;
import org.springframework.data.domain.Page;

/**
 * <p> 팀 서비스
 *
 * <p>packageName    : com.beyond.backend.service
 * <p>fileName       : TeamService
 * <p>author         : hongjm
 * <p>date           : 2025-02-03
 * <p>description    : 팀 서비스
 */
/*
 * ===========================================================
 * DATE              AUTHOR             NOTE
 * -----------------------------------------------------------
 * 2025-02-03        hongjm           최초 생성
 * 2025-02-15        hongjm           팀 검색 기능 추가
 * 2025-02-18        hongjm           팀 검색 페이징 기능 추가 및 보완
 * 2025-02-20        hongjm           팀 CRUD 수정
 */

public interface TeamService {
    TeamResponseDto createTeam(TeamDto teamDto);

    TeamResponseDto updateTeam(TeamDto team) throws Exception;

    Page<TeamSearchDto> filterUserTeams(
            Long userNo, String teamName, String teamIntroduce, String projectStatus, int page, int size);

    void deleteTeam(Long no) throws Exception;
}
