package com.beyond.backend.controller;

import com.beyond.backend.data.dto.TeamDto;
import com.beyond.backend.data.dto.TeamResponseDto;
import com.beyond.backend.data.dto.TeamSearchDto;
import com.beyond.backend.data.entity.Team;
import com.beyond.backend.service.TeamService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.stream.Collectors;

/**
 * <p> 팀 컨트롤러
 *
 * <p>packageName    : com.beyond.backend.controller
 * <p>fileName       : TeamController
 * <p>author         : hongjm
 * <p>date           : 2025-02-03
 * <p>description    : 팀 컨트롤러
 */
/*
 * ===========================================================
 * DATE              AUTHOR             NOTE
 * -----------------------------------------------------------
 * 2025-02-03        hongjm           최초 생성
 * 2025-02-18        hongjm           팀 조회 기능 추가
 */
@Tag(name = "팀 API", description = "팀 API")
@RestController
@RequestMapping("/team")
public class TeamController {
    private final TeamService teamService;

    public TeamController(TeamService teamService) {
        this.teamService = teamService;
    }

    @Operation(summary = "팀 생성 메서드", description = "팀 생성 메서드입니다.")
    @PostMapping()
    public ResponseEntity<TeamResponseDto> createTeam(@RequestBody TeamDto teamDto) {

        TeamResponseDto teamResponseDto = teamService.createTeam(teamDto);

        return ResponseEntity.status(HttpStatus.OK).body(teamResponseDto);
    }

    @Operation(summary = "팀 수정 메서드", description = "팀 수정 메서드 입니다.")
    @PutMapping()
    public ResponseEntity<TeamResponseDto> updateTeam(
            @RequestBody TeamResponseDto teamDto) throws Exception {

        teamService.updateTeam(teamDto);

        return ResponseEntity.status(HttpStatus.OK).body(teamDto);
    }

    @Operation(summary = "팀 조회 메서드", description = "유저 번호로 해당 유저의 모든 팀을 조회하는 메서드 입니다.")
    @GetMapping()
    public ResponseEntity<List<TeamSearchDto>> getUserTeams(
            @RequestParam Long userNo,
            @RequestParam(required = false)  String teamName,
            @RequestParam(required = false)  String teamIntroduce,
            @RequestParam(required = false)  String projectStatus){

        return ResponseEntity.status(HttpStatus.OK).body(teamService.filterUserTeams(userNo, teamName, teamIntroduce, projectStatus));
    }

    @Operation(summary = "팀 삭제 메서드", description = "팀 삭제 메서드입니다.")
    @DeleteMapping()
    public ResponseEntity<String> deleteTeam(Long teamId) throws Exception {
        teamService.deleteTeam(teamId);
        return ResponseEntity.status(HttpStatus.OK).body("정상적으로 삭제되었습니다.");
    }

}
