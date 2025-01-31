package com.beyond.backend.data.dto;

import lombok.*;

/**
 * <p>
 *
 * <p>packageName    : com.beyond.backend.data.dto
 * <p>fileName       : ProjectDto
 * <p>author         : jaewoo
 * <p>date           : 2025. 1. 31.
 * <p>description    : 프로젝트 DTO
 */
/*
 * ===========================================================
 * DATE              AUTHOR             NOTE
 * -----------------------------------------------------------
 * 2025. 1. 31.        jaewoo             최초 생성
 */

@Getter
@Setter
@ToString
@EqualsAndHashCode
@AllArgsConstructor
public class ProjectDto {

    private int project_id;

    private int team_id;

    private String project_name;

    private String duration;

    private String created_date;

    private String updated_date;
}
