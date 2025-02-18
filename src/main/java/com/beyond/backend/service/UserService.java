package com.beyond.backend.service;

import com.beyond.backend.data.dto.userDto.LoginDto;
import com.beyond.backend.data.dto.userDto.UserSignUpDto;

public interface UserService {

    Long join(UserSignUpDto userDto);

    LoginDto login(String username, String password);

}
