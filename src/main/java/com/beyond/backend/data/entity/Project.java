package com.beyond.backend.data.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import java.util.ArrayList;
import java.util.List;

/**
 * <p>
 *
 * <p>packageName    : com.beyond.backend.data.entity
 * <p>fileName       : Project
 * <p>author         : jaewoo
 * <p>date           : 2025. 2. 1.
 * <p>description    : 프로젝트 Entity
 */
/*
 * ===========================================================
 * DATE              AUTHOR             NOTE
 * -----------------------------------------------------------
 * 2025. 2. 1.        jaewoo             최초 생성
 * 2025. 2. 3.        jaewoo             변수명 수정
 * 2025. 2. 4.        jaewoo             변수명 수정
 */
@Entity
@Getter
@Setter
@NoArgsConstructor
@ToString
public class Project extends BaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "project_no")
    private Long no;

    @Column(nullable = false)
    private String name;

    private String projectPurpose;

    private String projectSubject;

    @Enumerated(EnumType.STRING)
    private ProjectStatus projectStatus;

    @Enumerated(EnumType.STRING)
    private ProjectType projectType;

    @OneToMany(mappedBy = "project", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<FeedBack> feedBacks = new ArrayList<>();

    @OneToMany(mappedBy = "project", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<ProjectTech> projectTeches;

    @OneToOne
    @JoinColumn(name = "team_id")
    private Team team;

    @Embedded
    private TimePeriod timePeriod;
}