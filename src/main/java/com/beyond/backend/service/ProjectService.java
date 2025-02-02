package com.beyond.backend.service;

import com.beyond.backend.data.dto.ProjectDto;
import com.beyond.backend.data.dto.ProjectResponseDto;

/**
 * <p>
 *
 * <p>packageName    : com.beyond.backend.service
 * <p>fileName       : ProjectService
 * <p>author         : jaewoo
 * <p>date           : 2025. 2. 2.
 * <p>description    : 프로젝트 Service
 */
/*
 * ===========================================================
 * DATE              AUTHOR             NOTE
 * -----------------------------------------------------------
 * 2025. 2. 2.        jaewoo             최초 생성
 */

public interface ProjectService {

    ProjectResponseDto createProject(ProjectDto projectDto);

    ProjectResponseDto getProject(Long id);

    ProjectResponseDto updateProject(Long id, String name, String content, int userCount) throws Exception;

    void deleteProject(Long id) throws Exception;
}
