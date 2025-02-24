package com.beyond.backend.data.repository.impl;

import com.beyond.backend.data.dto.postDto.PostResponseDto;
import com.beyond.backend.data.entity.BoardType;
import com.beyond.backend.data.entity.Post;
import com.beyond.backend.data.entity.Status;
import com.beyond.backend.data.repository.PostRepositoryCustom;
import com.querydsl.jpa.impl.JPAQueryFactory;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Slice;
import org.springframework.data.domain.SliceImpl;
import org.springframework.stereotype.Repository;
import static com.beyond.backend.data.entity.QPost.post;

import java.util.List;
import java.util.stream.Collectors;

/**
 * <p>
 *
 * <p>packageName    : com.beyond.backend.data.repository.impl
 * <p>fileName       : PostRepositoryImpl
 * <p>author         : hyunjo
 * <p>date           : 25. 2. 20.
 * <p>description    :
 */
/*
 * ===========================================================
 * DATE              AUTHOR             NOTE
 * -----------------------------------------------------------
 * 25. 2. 20.        hyunjo             최초 생성
 */@Repository
@RequiredArgsConstructor
public class PostRepositoryImpl implements PostRepositoryCustom {

    private final JPAQueryFactory queryFactory;

    @Override
    public Slice<PostResponseDto> getPostsByBoardType(BoardType boardType, Pageable pageable) {
        List<Post> posts = queryFactory
                .selectFrom(post)
                .where(post.boardType.eq(boardType), post.status.eq(Status.ACTIVE))
                .orderBy(post.timePeriod.createdAt.desc())
                .offset(pageable.getOffset())
                .limit(pageable.getPageSize() + 1)
                .fetch();

        boolean hasNext = posts.size() > pageable.getPageSize();
        if (hasNext) {
            posts.remove(posts.size() - 1);
        }

        return new SliceImpl<>(posts.stream().map(PostResponseDto::new).collect(Collectors.toList()), pageable, hasNext);
    }

    @Override
    public Slice<PostResponseDto> searchPosts(BoardType boardType, String keyword, Pageable pageable) {
        List<Post> posts = queryFactory
                .selectFrom(post)
                .where(
                        post.boardType.eq(boardType),
                        post.status.eq(Status.ACTIVE),
                        keyword != null ?
                                post.postTitle.containsIgnoreCase(keyword)
                                        .or(post.postContent.containsIgnoreCase(keyword))
                                        .or(post.user.username.containsIgnoreCase(keyword)) : null
                )
                .orderBy(post.timePeriod.createdAt.desc())
                .offset(pageable.getOffset())
                .limit(pageable.getPageSize() + 1)
                .fetch();

        boolean hasNext = posts.size() > pageable.getPageSize();
        if (hasNext) {
            posts.remove(posts.size() - 1);
        }

        return new SliceImpl<>(posts.stream().map(PostResponseDto::new).collect(Collectors.toList()), pageable, hasNext);
    }
}