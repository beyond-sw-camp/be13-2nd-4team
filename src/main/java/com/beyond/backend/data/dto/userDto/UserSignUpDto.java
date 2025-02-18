package com.beyond.backend.data.dto.userDto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class UserSignUpDto {

    @NotBlank(message = "필수 입력값입니다.")
    @Size(min = 4, max = 50, message = "4자 이상 50자 이하로 입력해야 합니다.")
    private String username;

    @NotBlank(message = "필수 입력값입니다.")
    private String name;

    @NotBlank(message = "필수 입력값입니다.")
    @Size(min = 8, message = "비밀번호는 최소 8자 이상 입력해야 합니다.")
    private String password;

    @NotBlank(message = "필수 입력값입니다.")
    @Email(message = "유효한 이메일 형식이어야 합니다.")
    private String email;

    private String phoneNum;

    private String address;

    public UserSignUpDto(String username, String name, String password, String email, String phoneNum, String address) {
        this.username = username;
        this.name = name;
        this.password = password;
        this.email = email;
        this.phoneNum = phoneNum;
        this.address = address;
    }
}