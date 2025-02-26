package com.beyond.backend.service;

import com.beyond.backend.data.dto.postDto.PostResponseDto;
import com.beyond.backend.data.entity.BoardType;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Slice;

/**
 * <p>
 *
 * <p>packageName    : com.beyond.backend.service
 * <p>fileName       : PostService
 * <p>author         : hyunjo
 * <p>date           : 25. 2. 2.
 * <p>description    :
 */
/*
 * ===========================================================
 * DATE              AUTHOR             NOTE
 * -----------------------------------------------------------
 * 25. 2. 2.        hyunjo             최초 생성
 * 25. 2. 17.       hyunjo             내용 수정
 * 25. 2. 20.       hyunjo             내용 수정
 */public interface PostService {

    Slice<PostResponseDto> getPosts(BoardType boardType, Pageable pageable);

    Slice<PostResponseDto> searchPosts(BoardType boardType, String keyword, Pageable pageable);

    PostResponseDto getPostById(Long postId);
}
