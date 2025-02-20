package com.beyond.backend.controller;

import com.beyond.backend.data.dto.userDto.LoginDto;
import com.beyond.backend.data.dto.userDto.UserSignUpDto;
import com.beyond.backend.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/user")
public class UserController {

    private final UserService userService;


    @PostMapping("/signup")
    public ResponseEntity<String> signup(@RequestBody UserSignUpDto request) {
        userService.join(request);
        return ResponseEntity.ok("회원가입");
    }

/*    @PostMapping("/login")
    public ResponseEntity<LoginDto> login(@RequestBody LoginDto request) {
        //LoginDto response = userService.login(request);
        return ResponseEntity.ok(response);
    }*/


    //필요할까?
/*    @GetMapping("/signup-url")
    public ResponseEntity<String> getSignupUrl() {
        return ResponseEntity.ok("/signup");
    }*/


}
