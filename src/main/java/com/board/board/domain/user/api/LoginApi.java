package com.board.board.domain.user.api;

import com.board.board.domain.user.application.LoginService;
import com.board.board.domain.user.dto.LoginRequest;
import com.board.board.domain.user.dto.TokenResponse;
import com.board.board.global.common.response.ApiResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RestController
@RequestMapping("login")
public class LoginApi {

    private final LoginService service;

    @PostMapping
    public ApiResponse<TokenResponse> login(@RequestBody LoginRequest request) {
        return new ApiResponse<>(HttpStatus.CREATED, service.login(request));

    }
}
