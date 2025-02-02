package com.beyond.backend.service.impl;

import com.beyond.backend.data.dto.ProductResponseDto;
import com.beyond.backend.data.dto.ProjectDto;
import com.beyond.backend.data.dto.ProjectResponseDto;
import com.beyond.backend.service.ProjectService;
import org.springframework.stereotype.Service;

/**
 * <p>
 *
 * <p>packageName    : com.beyond.backend.service.impl
 * <p>fileName       : ProjectServiceImpl
 * <p>author         : jaewoo
 * <p>date           : 2025. 2. 2.
 * <p>description    : 프로젝트 ServiceImpl
 */
/*
 * ===========================================================
 * DATE              AUTHOR             NOTE
 * -----------------------------------------------------------
 * 2025. 2. 2.        jaewoo             최초 생성
 */

@Service
public class ProjectServiceImpl implements ProjectService {

    /**
     * 프로젝트 생성
     * @param projectDto 프로젝트 정보
     * @return ProjectResponseDto
     * @see ProjectResponseDto
     */
    @Override
    public ProjectResponseDto postProject(ProjectDto projectDto) {
        return null;
    }
}
