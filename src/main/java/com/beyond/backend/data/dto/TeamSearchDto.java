package com.beyond.backend.data.dto;

import com.beyond.backend.data.entity.ProjectStatus;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

/**
 * <p>
 *
 * <p>packageName    : com.beyond.backend.data.dto
 * <p>fileName       : TeamUserDto
 * <p>author         : hongjm
 * <p>date           : 2025-02-16
 * <p>description    : 유저와 팀을 잇는 팀구성 Dto
 */
/*
 * ===========================================================
 * DATE              AUTHOR             NOTE
 * -----------------------------------------------------------
 * 2025-02-16        hongjm           최초 생성
 * 2025-02-18        hongjm           간소화
 */

@Data
@Builder
public class TeamSearchDto {

    private String teamName;

    private String teamIntroduce;

    private ProjectStatus projectStatus;

    private LocalDateTime createdAt;

}
