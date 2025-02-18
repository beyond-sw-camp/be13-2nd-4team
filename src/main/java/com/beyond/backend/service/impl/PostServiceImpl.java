package com.beyond.backend.service.impl;

import com.beyond.backend.data.dto.PostDto;
import com.beyond.backend.data.dto.PostResponseDto;
import com.beyond.backend.data.entity.Post;
import com.beyond.backend.data.repository.PostRepository;
import com.beyond.backend.service.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * <p>
 *
 * <p>packageName    : com.beyond.backend.service.impl
 * <p>fileName       : PostServiceImpl
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

@Service
public class PostServiceImpl implements PostService {

    private final PostRepository postRepository;

    @Autowired
    public PostServiceImpl(PostRepository postRepository) {
        this.postRepository = postRepository;
    }

    /**
     * 게시글 조회
     * @param id 게시글 번호
     * @return PostResponseDto postResponseDto
     * @see PostResponseDto
     */
    @Override
    public PostResponseDto getPost(Long id) {
        // 게시글 조회
        Post post = postRepository.findById(id).get();

        // PostResponseDto 생성
        PostResponseDto postResponseDto = new PostResponseDto();
//        postResponseDto.setId(post.getId());
//        postResponseDto.setTitle(post.getTitle());
//        postResponseDto.setContent(post.getContent());
//        postResponseDto.setUserId(post.getUserId());
//        postResponseDto.setCreatedAt(post.getCreatedAt().toString());
//        postResponseDto.setUpdatedAt(post.getUpdatedAt().toString());

        return postResponseDto;
    }

    /**
     * 게시글 등록
     * @param postDto 게시글 정보
     * @return PostResponseDto postResponseDto
     * @see PostResponseDto
     */
    @Override
    public PostResponseDto savePost(PostDto postDto) {
        // 게시글 엔티티 생성
        Post post = new Post();
//        post.setTitle(postDto.getTitle());
//        post.setContent(postDto.getContent());
//        post.setUserId(postDto.getUserId());

        // 게시글 저장
        Post savedPost = postRepository.save(post);

        // PostResponseDto 생성
        PostResponseDto postResponseDto = new PostResponseDto();
//        postResponseDto.setId(savedPost.getId());
//        postResponseDto.setTitle(savedPost.getTitle());
//        postResponseDto.setContent(savedPost.getContent());
//        postResponseDto.setUserId(savedPost.getUserId());
//        postResponseDto.setCreatedAt(savedPost.getCreatedAt().toString());
//        postResponseDto.setUpdatedAt(savedPost.getUpdatedAt().toString());

        return postResponseDto;
    }


    /**
     * 게시글 수정
     * @param id 게시글 ID
     * @param postDto 수정할 게시글 정보
     * @return PostResponseDto postResponseDto
     * @see PostResponseDto
     */
    @Override
    public PostResponseDto updatePost(Long id, PostDto postDto) {
        // 기존 게시글 조회 (값이 없으면 예외 발생)
        Post post = postRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("해당 ID의 게시글이 존재하지 않습니다. ID: " + id));

        // 게시글 정보 업데이트
//        post.setTitle(postDto.getTitle());
//        post.setContent(postDto.getContent());
//        post.setUserId(postDto.getUserId());

        // 수정된 게시글 저장
        Post updatedPost = postRepository.save(post);

        // PostResponseDto 생성 후 반환

        PostResponseDto postResponseDto = new PostResponseDto();
//        postResponseDto.setId(updatedPost.getId());
//        postResponseDto.setTitle(updatedPost.getTitle());
//        postResponseDto.setContent(updatedPost.getContent());
//        postResponseDto.setUserId(updatedPost.getUserId());
//        postResponseDto.setCreatedAt(updatedPost.getCreatedAt().toString());
//        postResponseDto.setUpdatedAt(updatedPost.getUpdatedAt().toString());


        return postResponseDto;
    }

    /**
     * 게시글 삭제
     * @param id
     */
    @Override
    public void deletePost(Long id) throws Exception{
        postRepository.deleteById(id);
    }
}