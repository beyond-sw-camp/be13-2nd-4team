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
 * 2025. 2. 2.         jaewoo             내용 수정
 * 2025. 2. 3.         jaewoo             변수명 수정
 */

@Getter
@Setter
@ToString
@EqualsAndHashCode
@AllArgsConstructor
public class ProjectDto {

    private String name;

    private String content;

    private int user_Count;
}
