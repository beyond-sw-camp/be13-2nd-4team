package com.beyond.backend.controller;

import com.beyond.backend.data.dto.ProductDto;
import com.beyond.backend.data.dto.ProductResponseDto;
import com.beyond.backend.data.dto.ProjectDto;
import com.beyond.backend.data.dto.ProjectResponseDto;
import com.beyond.backend.service.ProjectService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

/**
 * <p>프로젝트 API
 *
 * <p>packageName    : com.beyond.backend.controller
 * <p>fileName       : ProjectController
 * <p>author         : jaewoo
 * <p>date           : 2025. 2. 2.
 * <p>description    : 프로젝트 API
 */
/*
 * ===========================================================
 * DATE              AUTHOR             NOTE
 * -----------------------------------------------------------
 * 2025. 2. 2.        jaewoo             최초 생성
 */

@Tag(name = "프로젝트 API", description = "프로젝트 API")
@RestController
@RequestMapping("/project")
public class ProjectController {
    private final ProjectService projectService;

    public ProjectController(ProjectService projectService) {
        this.projectService = projectService;
    }

    /**
     * Test 메서드
     *
     * @return the string
     */
    @Operation(summary = "test 메서드", description = "test 메서드입니다.")
    @GetMapping(value = "/test")
    public String getHello(){
        return "Hello World";
    }

    /**
     * Get product response entity.
     *
     * @param id the number
     * @return the response entity
     */
    @Operation(summary = "프로젝트 조회 메서드", description = "프로젝트 조회 메서드입니다.")
    @GetMapping()
    public ResponseEntity<ProjectResponseDto> getProject(Long id){
        ProjectResponseDto projectResponseDto = projectService.getProject(id);

        return ResponseEntity.status(HttpStatus.OK).body(projectResponseDto);
    }

    @Operation(summary = "프로젝트 등록 메서드", description = "프로젝트 등록 메서드입니다.")
    @PostMapping()
    public ResponseEntity<ProjectResponseDto> createProject(@RequestBody ProjectDto projectDto) {

        ProjectResponseDto projectResponseDto = projectService.createProject(projectDto);

        return ResponseEntity.status(HttpStatus.OK).body(projectResponseDto);
    }


}
