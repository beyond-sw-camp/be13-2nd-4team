package com.beyond.backend.data.dto;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

/**
 * <p>상품 응답 Dto
 *
 * <p>packageName    : com.beyond.backend.data.dto
 * <p>fileName       : ProductResponseDto
 * <p>author         : hjsong
 * <p>date           : 2025-01-18
 * <p>description    : 상품 응답 Dto
 */
/*
 * ===========================================================
 * DATE              AUTHOR             NOTE
 * -----------------------------------------------------------
 * 2025-01-18        hjsong             최초 생성
 * 2025-01-20        hjsong             파일명 이니셜(_shj) 삭제
 */
@Getter
@Setter
@ToString
@EqualsAndHashCode
@NoArgsConstructor
@AllArgsConstructor
public class ProductResponseDto {

    private Long number;

    private String name;

    private int price;

    private int stock;
}
