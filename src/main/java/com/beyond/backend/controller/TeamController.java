package com.beyond.backend.controller;

import com.beyond.backend.data.dto.teamDto.TeamDto;
import com.beyond.backend.data.dto.teamDto.TeamMemberListDto;
import com.beyond.backend.data.dto.teamDto.TeamResponseDto;
import com.beyond.backend.data.dto.teamDto.TeamSearchDto;
import com.beyond.backend.data.entity.ProjectStatus;
import com.beyond.backend.data.repository.TeamUserRepository;
import com.beyond.backend.service.TeamService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

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
 * 2025-02-20        hongjm           팀 CRUD 수정
 */
@Tag(name = "팀 API", description = "팀 API")
@RestController
@RequestMapping("/team")
public class TeamController {

    private final TeamService teamService;

    public TeamController(TeamService teamService) {
        this.teamService = teamService;
    }

    /**
     * 팀 생성 메소드
     * @param userNo 유저번호
     * @param teamName 팀 이름
     * @param teamIntroduce 팀 설명
     * @param projectStatus 프로젝트 상태
     * @return teamResponseDto
     */
    @Operation(summary = "팀 생성 메서드", description = "팀 생성 메서드입니다.")
    @PostMapping("/create")
    public ResponseEntity<TeamResponseDto> createTeam(
            @RequestParam Long userNo,
            @RequestParam String teamName,
            @RequestParam(required = false) String teamIntroduce,
            @RequestParam ProjectStatus projectStatus){

        TeamDto teamDto = new TeamDto(userNo, teamName, teamIntroduce, projectStatus);

        TeamResponseDto teamResponseDto = teamService.createTeam(teamDto);

        return ResponseEntity.status(HttpStatus.OK).body(teamResponseDto);
    }

    /**
     * 팀 수정 메소드
     * @param teamNo 팀 번호
     * @param teamName 팀 이름
     * @param teamIntroduce 팀 정보
     * @param projectStatus 팀 상태
     * @return teamDto
     */
    @Operation(summary = "팀 수정 메서드", description = "팀 수정 메서드 입니다.")
    @PutMapping("/setting/update")
    public ResponseEntity<TeamDto> updateTeam(
            @RequestParam Long teamNo,
            @RequestParam String teamName,
            @RequestParam(required = false) String teamIntroduce,
            @RequestParam ProjectStatus projectStatus) throws Exception {

        TeamDto teamDto = new TeamDto(teamNo, teamName, teamIntroduce, projectStatus);

        teamService.updateTeam(teamDto);

        return ResponseEntity.status(HttpStatus.OK).body(teamDto);
    }

    /**
     * userNo로 팀 정보를 조회하는 메서드
     *
     * @param userNo 유저 번호
     * @param teamName (검색용) 팀이름
     * @param teamIntroduce (검색용) 팀 설명
     * @param projectStatus (검색용) 팀 상태
     * @param page 최소 출력 값
     * @param size 최대 출력 값
     * @return teamSearch 검색 결과값 반환
     */
    @Operation(summary = "팀 조회 메서드", description = "유저 번호로 해당 유저의 모든 팀을 조회하는 메서드 입니다.")
    @GetMapping("/find")
    public ResponseEntity<Page<TeamSearchDto>> getUserTeams(
            @RequestParam Long userNo,
            @RequestParam(required = false)  String teamName,
            @RequestParam(required = false)  String teamIntroduce,
            @RequestParam(required = false)  String projectStatus,
            @RequestParam int page,
            @RequestParam int size){

        Page<TeamSearchDto> teamSearch = teamService.filterUserTeams(userNo, teamName, teamIntroduce, projectStatus, page, size);

        return ResponseEntity.status(HttpStatus.OK).body(teamSearch);
    }

    /**
     * 팀 삭제 메서드
     * @param teamNo 팀no
     * @return 없음
     * @throws Exception 팀이 존재하지 않습니다.
     */
    @Operation(summary = "팀 삭제 메서드", description = "팀 삭제 메서드입니다.")
    @DeleteMapping("/setting/delete")
    public ResponseEntity<String> deleteTeam(Long teamNo) throws Exception {

        teamService.deleteTeam(teamNo);

        return ResponseEntity.status(HttpStatus.OK).body("정상적으로 삭제되었습니다.");
    }

    /**
     * [팀장] 팀원 신청 목록 조회
     * @param teamNo 팀번호
     * @param userNo 유저번호
     * @return TeamMemberListDto
     * @throws Exception 권한이 없습니다!
     */
    @Operation(summary = "[팀장] 팀원 신청 목록 조회", description = "팀원 신청 목록 조회 메서드입니다.")
    @GetMapping("/member/setting")
    public ResponseEntity<List<TeamMemberListDto>> getMemberRequest(
            @RequestParam Long teamNo,
            @RequestParam Long userNo) throws Exception {
        List<TeamMemberListDto> teamMemberRequest = teamService.getTeamMemberRequest(teamNo, userNo);

        return ResponseEntity.status(HttpStatus.OK).body(teamMemberRequest);
    }

    /**
     * 팀원 목록 조회 메서드
     * @param teamNo 팀번호
     * @param userNo 유저번호
     * @return TeamMemberListDto
     * @throws Exception 팀이 존재하지 않습니다.
     */
    @Operation(summary = "팀원 목록 조회 메서드", description = "팀원 목록 조회 메서드입니다.")
    @GetMapping("/find/team")
    public ResponseEntity<List<TeamMemberListDto>> getUserTeams(
            @RequestParam Long teamNo,
            @RequestParam Long userNo) throws Exception {
        List<TeamMemberListDto> teamMembers = teamService.getTeamMembers(teamNo, userNo);

        return ResponseEntity.status(HttpStatus.OK).body(teamMembers);
    }

    /**
     * 팀원 추가 신청 메서드
     * @param teamNo 팀번호
     * @param userNo 유저번호
     * @return 없음
     * @throws Exception 팀이 존재하지 않습니다.
     * @throws Exception 유저가 존재하지 않습니다.
     * @throws Exception 모집중이 아닙니다!
     * @throws Exception 이미 등록되었거나 요청한 팀 입니다!!
     */
    @Operation(summary = "팀원 추가 신청 메서드", description = "팀원 추가 신청 메서드입니다.")
    @PostMapping("/joinRequest")
    public ResponseEntity<String> teamJoinRequest (Long teamNo, Long userNo) throws Exception {
        teamService.teamJoinRequest(teamNo, userNo);

        return ResponseEntity.status(HttpStatus.OK).body("정상적으로 신청되었습니다.");
    }


}
