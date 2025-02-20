package com.beyond.backend.service.impl;

import com.beyond.backend.data.dto.MessageDto;
import com.beyond.backend.data.dto.MessageResponseDto;
import com.beyond.backend.data.entity.Message;
import com.beyond.backend.data.entity.User;
import com.beyond.backend.data.repository.MessageRepository;
import com.beyond.backend.data.repository.UserRepository;
import com.beyond.backend.service.MessageService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static com.beyond.backend.data.dto.MessageResponseDto.returnMessageDto;

/**
 * <p>
 * <p>packageName    : com.beyond.backend.service.impl
 * <p>fileName       : MessageServiceImpl
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
@Service
@RequiredArgsConstructor
public class MessageServiceImpl implements MessageService {
    private final MessageRepository messageRepository;
    private final UserRepository userRepository;

    @Override
    public MessageResponseDto getMessage(Long id, String username) {
        Message message = messageRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("메시지가 없습니다"));
        if (!message.getReceiver().getUsername().equals(username) && !message.getSender().getUsername().equals(username)) {
            throw new RuntimeException("해당 메시지를 조회할 권한이 없습니다.");
        } else if (message.getReceiver().getUsername().equals(username)) {
            message.markAsRead();
            messageRepository.save(message);
        }
        return returnMessageDto(message);
    }

    @Override
    @Transactional
    public MessageResponseDto messageWrite(MessageDto messageDto) {
        Optional<User> sender = userRepository.findByUsername(messageDto.getSender());
        Optional<User> receiver = userRepository.findByUsername(messageDto.getReceiver());
        if (sender.isPresent() && receiver.isPresent()) {
            Message message = Message.builder()
                    .sender(sender.get())
                    .receiver(receiver.get())
                    .content(messageDto.getContent())
                    .sentAt(messageDto.getSendAt())
                    .deletedBySender(false)
                    .deletedByReceiver(false)
                    .build();
            messageRepository.save(message);

            return returnMessageDto(message);
        } else {
            throw new RuntimeException();
        }
    }

    @Transactional
    public Object deleteMessageByReceiver(Long id, String username) { // 시큐리티 되면 user 객체로
        Message message = messageRepository.findById(id).orElseThrow(()
                -> new IllegalArgumentException("존재하지 않는 메시지입니다."));

//        if (user == message.getReceiver()) { // 시큐리티되면 이거로
        if (username.equals(message.getReceiver().getUsername())) {
            message.deleteByReceiver(); // 받은 사람에게 메시지 삭제
            if (message.isDeleted()) {
                messageRepository.delete(message);
                return "양쪽 모두 삭제";
            }
            return "한쪽만 삭제";
        } else {
            throw new IllegalArgumentException("유저 정보가 일치하지 않습니다.");
        }
    }

    @Transactional
    public Object deleteMessageBySender(Long id, String username) { // 시큐리티 되면 user 객체로
        Message message = messageRepository.findById(id).orElseThrow(()
                -> new IllegalArgumentException("존재하지 않는 메시지입니다."));

//        if (user == message.getSender()) { // user == message.getSender() 로 수정하기
        if (message.getSender().getUsername().equals(username)) {
            message.deleteBySender();
            if (message.isDeleted()) {
                messageRepository.delete(message);
                return "양쪽 모두 삭제";
            }
            return "한쪽만 삭제";
        } else {
            throw new IllegalArgumentException("유저 정보가 일치하지 않습니다.");
        }
    }

    @Transactional
    public List<MessageResponseDto> sentMessages(String username) { // 시큐리티 되면 user 객체로
        List<Message> messages = messageRepository.findAllBySender_Username(username);
        List<MessageResponseDto> messageResponseDto = new ArrayList<>();
        for (Message message : messages) {
            if (!message.isDeletedBySender()) {
                messageResponseDto.add(returnMessageDto(message));
            }
        }
        return messageResponseDto;
    }

    @Override
    @Transactional
    public List<MessageResponseDto> receivedMessages(String username) { // 시큐리티 되면 user 객체로
        List<Message> messages = messageRepository.findAllByReceiver_Username(username);
        List<MessageResponseDto> messageResponseDto = new ArrayList<>();
        for (Message message : messages) {
            if (!message.isDeletedByReceiver()) {
                messageResponseDto.add(returnMessageDto(message));
            }
        }
        return messageResponseDto;
    }
}
