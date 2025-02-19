package com.beyond.backend.service;

import com.beyond.backend.data.dto.MessageDto;
import com.beyond.backend.data.dto.MessageResponseDto;

import java.util.List;

/**
 * <p>
 * <p>packageName    : com.beyond.backend.service
 * <p>fileName       : MessageService
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

public interface MessageService {

    MessageResponseDto getMessage(Long id, String userId); // 단일 조회

    MessageResponseDto messageWrite(MessageDto messageDto);

    Object deleteMessageBySender(Long id, String userId);

    Object deleteMessageByReceiver(Long id, String userId);

    List<MessageResponseDto> sentMessages(String userId);

    List<MessageResponseDto> receivedMessages(String userId);
    // 3,4,5,6 얘네 나중에 시큐리티? 되면 User 객체로..
}
