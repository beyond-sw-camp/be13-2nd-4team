package com.beyond.backend.data.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

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
 */
@Entity
@Getter
@Setter
@NoArgsConstructor
@ToString
@Table(name = "project")
public class Project extends BaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String name;

    private String content;

    private int user_Count;
}
