package com.beyond.backend.data.dto;

import com.beyond.backend.data.entity.ProjectStatus;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * <p>
 *
 * <p>packageName    : com.beyond.backend.data.dto
 * <p>fileName       : TeamResponseDto
 * <p>author         : hongjm
 * <p>date           : 2025-02-03
 * <p>description    : 팀 상세 Dto
 */
/*
 * ===========================================================
 * DATE              AUTHOR             NOTE
 * -----------------------------------------------------------
 * 2025-02-03        hongjm           최초 생성
 * 2025-02-16        hongjm           Entity에 맞춰 수정
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class TeamResponseDto {

    private long id;

    private String teamName;

    private String teamIntroduce;

    private ProjectStatus projectStatus;

}
