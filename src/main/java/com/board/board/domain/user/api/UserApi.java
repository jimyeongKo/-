package com.board.board.domain.user.api;

import com.board.board.domain.user.application.UserService;
import com.board.board.domain.user.domain.User;
import com.board.board.domain.user.dto.TokenResponse;
import com.board.board.global.common.response.ApiResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RestController
@RequestMapping("/user")
public class UserApi {
    private final UserService service;

    @GetMapping("/me")
    public ApiResponse<TokenResponse> me(@AuthenticationPrincipal User user) {
        return new ApiResponse<>(HttpStatus.OK, service.me(user));
    }


}
