package com.beyond.backend.data.dto.userDto;

import com.beyond.backend.data.entity.User;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class LoginDto {

    @NotBlank(message = "필수 입력값입니다.")
    private String username;

    @NotBlank(message = "필수 입력값입니다.")
    private String password;

    public LoginDto(User user) {
        this.username = user.getUsername();
        this.password = user.getPassword();
    }
}
