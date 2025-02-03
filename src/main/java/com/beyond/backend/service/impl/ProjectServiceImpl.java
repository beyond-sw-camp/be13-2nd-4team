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
 * 2025. 2. 3.        jaewoo             함수명 수정
 * 2025. 2. 4.        jaewoo             함수명 수정
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

    /**
     * 프로젝트 조회
     * @param id 프로젝트 ID
     * @return ProjectResponseDto projectResponseDto
     * @see ProjectResponseDto
     */
    @Override
    public ProjectResponseDto getProject(Long id) {
        Project project = projectRepository.findById(id).get();

        ProjectResponseDto projectResponseDto = new ProjectResponseDto();
        projectResponseDto.setId(project.getId());
        projectResponseDto.setName(project.getName());
        projectResponseDto.setContent(project.getContent());
        projectResponseDto.setUserCount(project.getUserCount());

        return projectResponseDto;
    }

    /**
     * 프로젝트 업데이트
     * @param id 프로젝트 ID
     * @param name 프로젝트 명
     * @param content 프로젝트 내용
     * @param userCount 프로젝트 팀원 수
     * @return ProjectResponseDto projectResponseDto
     * @see ProjectResponseDto
     * @throws Exception
     */
    @Override
    public ProjectResponseDto updateProject(Long id, String name, String content, int userCount) throws Exception {
        Project foundProject = projectRepository.findById(id).get();
        foundProject.setName(name);
        foundProject.setContent(content);
        foundProject.setUserCount(userCount);

        Project updateProject = projectRepository.save(foundProject);

        ProjectResponseDto projectResponseDto = new ProjectResponseDto();
        projectResponseDto.setId(updateProject.getId());
        projectResponseDto.setName(updateProject.getName());
        projectResponseDto.setContent(updateProject.getContent());
        projectResponseDto.setUserCount(updateProject.getUserCount());

        return projectResponseDto;
    }

    /**
     * 프로젝트 삭제
     * @param id 상품 ID
     * @throws Exception
     */
    @Override
    public void deleteProject(Long id) throws Exception {
        projectRepository.deleteById(id);
    }
}
