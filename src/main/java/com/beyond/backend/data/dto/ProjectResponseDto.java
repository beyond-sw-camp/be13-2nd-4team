package com.beyond.backend.data.dto;

import com.beyond.backend.data.entity.FeedBack;
import com.beyond.backend.data.entity.ProjectStatus;
import com.beyond.backend.data.entity.ProjectTech;
import com.beyond.backend.data.entity.ProjectType;
import com.beyond.backend.data.entity.Team;
import com.beyond.backend.data.entity.TimePeriod;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Embedded;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import lombok.*;

import java.util.ArrayList;
import java.util.List;

/**
 * <p>
 *
 * <p>packageName    : com.beyond.backend.data.dto
 * <p>fileName       : ProjectResponseDto
 * <p>author         : jaewoo
 * <p>date           : 2025. 2. 2.
 * <p>description    : 프로젝트 응답 Dto
 */
/*
 * ===========================================================
 * DATE              AUTHOR             NOTE
 * -----------------------------------------------------------
 * 2025. 2. 2.        jaewoo             최초 생성
 * 2025. 2. 3.        jaewoo             변수명 수정
 * 2025. 2. 4.        jaewoo             변수명 수정
 * 2025. 2. 17.       jaewoo             Entity에 맞게 수정
 * 2025. 2. 18.       jaewoo             순환참조 해결을 위해서 team이 아닌 teamNo를 받아오게끔 작성
 */

@Getter
@Setter
@ToString
@EqualsAndHashCode
@NoArgsConstructor
public class ProjectResponseDto {

    private Long id;

    private String name;

    private String projectPurpose;

    private String projectSubject;

    private ProjectStatus projectStatus;

    private Long teamNo;


    public ProjectResponseDto(Project project) {
        this.no = project.getNo();
        this.name = project.getName();
        this.projectPurpose = project.getProjectPurpose();
        this.projectSubject = project.getProjectSubject();
        this.projectStatus = project.getProjectStatus();
        this.teamNo = project.getTeam().getNo();
    }
}
