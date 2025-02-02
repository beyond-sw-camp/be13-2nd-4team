package com.beyond.backend.service.impl;

import com.beyond.backend.data.dto.ProjectDto;
import com.beyond.backend.data.dto.ProjectResponseDto;
import com.beyond.backend.data.entity.Project;
import com.beyond.backend.data.repository.ProjectRepository;
import com.beyond.backend.service.ProjectService;
import org.springframework.beans.factory.annotation.Autowired;
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
    private final ProjectRepository projectRepository;

    /**
     * ProjectRepository 생성자
     * @param projectRepository 프로젝트 Repository
     * @see ProjectRepository
     */
    @Autowired
    public ProjectServiceImpl(ProjectRepository projectRepository) {
        this.projectRepository = projectRepository;
    }

    /**
     * 프로젝트 생성
     * @param projectDto 프로젝트 정보
     * @return ProjectResponseDto
     * @see ProjectResponseDto
     */
    @Override
    public ProjectResponseDto createProject(ProjectDto projectDto) {
        Project project = new Project();
        project.setName(projectDto.getName());
        project.setContent(projectDto.getContent());
        project.setUserCount(projectDto.getUserCount());

        Project savedProject = projectRepository.save(project);
        ProjectResponseDto projectResponseDto = new ProjectResponseDto();
        projectResponseDto.setId(savedProject.getId());
        projectResponseDto.setName(savedProject.getName());
        projectResponseDto.setContent(savedProject.getContent());
        projectResponseDto.setUserCount(savedProject.getUserCount());

        return projectResponseDto;
    }
}
