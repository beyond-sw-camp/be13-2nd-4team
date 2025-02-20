package com.beyond.backend.data.repository;

import com.beyond.backend.data.dto.postDto.PostResponseDto;
import com.beyond.backend.data.entity.BoardType;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Slice;

/**
 * <p>
 *
 * <p>packageName    : com.beyond.backend.data.repository
 * <p>fileName       : PostRepositoryCustom
 * <p>author         : hyunjo
 * <p>date           : 25. 2. 20.
 * <p>description    :
 */
/*
 * ===========================================================
 * DATE              AUTHOR             NOTE
 * -----------------------------------------------------------
 * 25. 2. 20.        hyunjo             최초 생성
 */public interface PostRepositoryCustom {
    Slice<PostResponseDto> getPostsByBoardType(BoardType boardType, Pageable pageable);

    Slice<PostResponseDto> searchPosts(BoardType boardType, String keyword, Pageable pageable);
}