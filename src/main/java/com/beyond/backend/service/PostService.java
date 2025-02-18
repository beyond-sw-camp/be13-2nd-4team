package com.beyond.backend.service;

import com.beyond.backend.data.dto.PostDto;
import com.beyond.backend.data.dto.PostResponseDto;

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
 */public interface PostService {

    PostResponseDto getPost(Long id);

    PostResponseDto savePost(PostDto postDto);

    PostResponseDto updatePost(Long id, PostDto postDto) throws Exception;

    void deletePost(Long id) throws Exception;
}
