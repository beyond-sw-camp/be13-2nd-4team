package com.beyond.backend.data.repository;

import com.beyond.backend.data.entity.Message;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * <p>
 * <p>packageName    : com.beyond.backend.data.repository
 * <p>fileName       : MessageRepository
 * <p>author         : mlnstone
 * <p>date           : 2025. 2. 16.
 * <p>description    :
 */
/*
===========================================================
DATE              AUTHOR             NOTE
-----------------------------------------------------------
2025. 2. 16.        mlnstone             최초 생성
*/

public interface MessageRepository extends JpaRepository<Message, Long> {
    List<Message> findAllBySender_UserId(String userId); // 시큐리티 되면 user 객체로

    List<Message> findAllByReceiver_UserId(String userId);// 시큐리티 되면 user 객체로
}
