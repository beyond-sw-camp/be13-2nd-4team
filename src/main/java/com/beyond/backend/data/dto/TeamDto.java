package com.beyond.backend.data.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

/**
 * <p>
 *
 * <p>packageName    : com.beyond.backend.data.dto
 * <p>fileName       : TeamDto
 * <p>author         : hongjm
 * <p>date           : 2025-02-03
 * <p>description    : 팀 Dto
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
@AllArgsConstructor
public class TeamDto {

    private long id;

    private String teamName;

    private String teamIntroduce;

    private String projectStatus;

}
