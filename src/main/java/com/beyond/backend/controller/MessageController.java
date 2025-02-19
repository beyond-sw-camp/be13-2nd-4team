package com.beyond.backend.controller;

import com.beyond.backend.data.dto.MessageDto;
import com.beyond.backend.data.dto.MessageResponseDto;
import com.beyond.backend.data.entity.User;
import com.beyond.backend.data.repository.UserRepository;
import com.beyond.backend.service.MessageService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/message")
@RequiredArgsConstructor
public class MessageController {
    private final MessageService messageService;
    private final UserRepository userRepository;


    @GetMapping("/read/{userId}/{no}")
    public ResponseEntity<MessageResponseDto> getMessage(@PathVariable Long no, @PathVariable String userId) { // 유저 아이디, 메시지 아이디 /

        MessageResponseDto messageResponseDto = messageService.getMessage(no, userId);

        return ResponseEntity.status(HttpStatus.OK).body(messageResponseDto);
    }

    @PostMapping("/write")
    public ResponseEntity<MessageResponseDto> sendMessage(@RequestBody MessageDto messageDto) {
        MessageResponseDto messageResponseDto = messageService.messageWrite(messageDto);

        return ResponseEntity.status(HttpStatus.OK).body(messageResponseDto);
    }

    @GetMapping("/list/received/{userId}")
    public ResponseEntity<List<MessageResponseDto>> getReceivedMessage(@PathVariable String userId) {
        User user = userRepository.findByUserId(userId)
                .orElseThrow(() -> new IllegalArgumentException("User not found"));
        List<MessageResponseDto> messageResponseDto = messageService.receivedMessages(user.getUserId());
        return ResponseEntity.ok(messageResponseDto);
    } // try catch 로..?

    @GetMapping("/list/sent/{userId}")
    public ResponseEntity<List<MessageResponseDto>> getSentMessage(@PathVariable String userId) { // User 객체로 바꾸기
        User user = userRepository.findByUserId(userId)
                .orElseThrow(() -> new IllegalArgumentException("User not found"));
        List<MessageResponseDto> messageResponseDto = messageService.sentMessages(user.getUserId());
        return ResponseEntity.ok(messageResponseDto);
    }

    @DeleteMapping("/delete/sent")
    public ResponseEntity<MessageResponseDto> deleteSentMessage(@RequestParam Long no, @RequestParam String userId) {
//        User user = userRepository.findByUserId(user.getNo())
//                .orElseThrow(() -> new IllegalArgumentException("User not found"));
        // 현재 로그인 한 계정 번호

        messageService.deleteMessageBySender(no, userId);
        return deleteResponse();
    }

    @DeleteMapping("/delete/received")
    public ResponseEntity<MessageResponseDto> deleteReceivedMessage(@RequestParam Long no, @RequestParam String userId) {
//        User user = userRepository.findByUserId(user.getNo())
//                .orElseThrow(() -> new IllegalArgumentException("User not found"));
        // 현재 로그인 한 계정 번호

        messageService.deleteMessageByReceiver(no, userId);
        return deleteResponse();
    }

    private ResponseEntity<MessageResponseDto> deleteResponse() {
        MessageResponseDto responseDto = MessageResponseDto.fromContent("삭제 되었습니다."); // 유저, 메시지 일치하지않는것 추가하기 일단 throw
        return ResponseEntity.status(HttpStatus.OK).body(responseDto);
    }

//    @DeleteMapping("/delete")
//    public ResponseEntity<String> deleteMessage(Long id) throws Exception {
//        messageService.deleteMessage(id);
//
//        return ResponseEntity.status(HttpStatus.OK).body("정상적으로 삭제되었습니다");
//    }
}
