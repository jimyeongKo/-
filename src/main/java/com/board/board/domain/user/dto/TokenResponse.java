package com.board.board.domain.user.dto;


import com.board.board.domain.user.domain.User;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class TokenResponse {

    private String token;

    private UserResponse user;

    public TokenResponse(String token,final User user) {
        this.token = token;
        this.user = new UserResponse(user);
    }
}
