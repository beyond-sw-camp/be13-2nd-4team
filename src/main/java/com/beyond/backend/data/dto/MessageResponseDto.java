package com.beyond.backend.data.dto;

import com.beyond.backend.data.entity.Message;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

/**
 * <p>
 * <p>packageName    : com.beyond.backend.data.dto
 * <p>fileName       : MessageResponseDto
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

@Data
@NoArgsConstructor
@AllArgsConstructor
public class MessageResponseDto {

    private Long messageId;
    private String content;
    private String sender;
    private String receiver;
    private LocalDateTime sendAt;

    // 생성자 대신 메서드는??
    public static MessageResponseDto returnMessageDto(Message message) {
        return new MessageResponseDto(message.getNo(), message.getContent(),
                message.getSender().getName(), message.getReceiver().getName(), message.getSentAt());
    }
    // 하다가 깨달음

    public static MessageResponseDto fromContent(String content) {
        MessageResponseDto dto = new MessageResponseDto();
        dto.content = content;
        return dto;
    }
    //

}
