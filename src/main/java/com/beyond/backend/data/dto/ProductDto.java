package com.beyond.backend.data.dto;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

/**
 * <p>상품 Dto
 *
 * <p>packageName    : com.beyond.backend.data.dto
 * <p>fileName       : ProductDto
 * <p>author         : hjsong
 * <p>date           : 2025-01-18
 * <p>description    : 상품 Dto
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
@AllArgsConstructor
public class ProductDto {

    private String name;

    private int price;

    private int stock;

}
