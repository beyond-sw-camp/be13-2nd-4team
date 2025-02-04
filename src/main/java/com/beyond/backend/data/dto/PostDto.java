package com.beyond.backend.data.dto;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

/**
 * <p>
 *
 * <p>packageName    : com.beyond.backend.data.dto
 * <p>fileName       : PostDto
 * <p>author         : hyunjo
 * <p>date           : 25. 2. 2.
 * <p>description    :
 */
/*
 * ===========================================================
 * DATE              AUTHOR             NOTE
 * -----------------------------------------------------------
 * 25. 2. 2.        hyunjo             최초 생성
 */
@Getter
@Setter
@ToString
@EqualsAndHashCode
@AllArgsConstructor
public class PostDto {


    private String title;
    private String content;
    private String userId;
}
