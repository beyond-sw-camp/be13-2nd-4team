package com.beyond.backend.service.impl;

import com.beyond.backend.data.dto.ProjectDto;
import com.beyond.backend.data.dto.ProjectResponseDto;
import com.beyond.backend.data.entity.Project;
import com.beyond.backend.data.repository.ProjectRepository;
import com.beyond.backend.service.ProjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
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
 * 2025. 2. 16.       jaewoo             getUserProjects 함수 작성
 * 2025. 2. 17.       jaewoo             getProjectsByUsername 함수에 teamNo가 매개변수가 되게 작성
 * 2025. 2. 17.       jaewoo             getProjectsByTeamNo 함수명 변경
 * 2025. 2. 18.       jaewoo             teamNo를 알고 있는 상황이기 때문에 불필요한 코드 제거
 * 2025. 2. 18.       jaewoo             페이징 처리 코드 작성
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
//        project.setName(projectDto.getName());
//        project.setContent(projectDto.getContent());
//        project.setUserCount(projectDto.getUserCount());

        Project savedProject = projectRepository.save(project);
        ProjectResponseDto projectResponseDto = new ProjectResponseDto();
//        projectResponseDto.setId(savedProject.getId());
//        projectResponseDto.setName(savedProject.getName());
//        projectResponseDto.setContent(savedProject.getContent());
//        projectResponseDto.setUserCount(savedProject.getUserCount());

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
//        foundProject.setName(name);
//        foundProject.setContent(content);
//        foundProject.setUserCount(userCount);

        Project updateProject = projectRepository.save(foundProject);

        ProjectResponseDto projectResponseDto = new ProjectResponseDto();
//        projectResponseDto.setId(updateProject.getId());
//        projectResponseDto.setName(updateProject.getName());
//        projectResponseDto.setContent(updateProject.getContent());
//        projectResponseDto.setUserCount(updateProject.getUserCount());

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

    /**
     * 프로젝트 조회
     * @param teamNo 팀 id
     * @param pageable 페이지
     * @return Page ProgectResponseDto
     */
    @Override
    public Page<ProjectResponseDto> getProjectsByTeamNo(Long teamNo, Pageable pageable) {
        Page<Project> projectPage = projectRepository.findByTeamNo(teamNo, pageable);

        return projectPage.map(project -> {
            ProjectResponseDto dto = new ProjectResponseDto();

            dto.setId(project.getNo());
            dto.setName(project.getName());
            // dto.setProjectPurpose(project.getProjectPurpose());
            // dto.setProjectSubject(project.getProjectSubject());
            // dto.setProjectStatus(project.getProjectStatus());
            // dto.setProjectType(project.getProjectType());
            // dto.setFeedBacks(project.getFeedBacks());
            // dto.setProjectTeches(project.getProjectTeches());
            dto.setTeamNo(teamNo);
            dto.setTimePeriod(project.getTimePeriod());

            return dto;
        });
    }
}
