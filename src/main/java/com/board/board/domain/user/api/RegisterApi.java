package com.board.board.domain.user.api;

import com.board.board.domain.user.application.RegisterService;
import com.board.board.domain.user.dto.UserRequest;
import com.board.board.domain.user.dto.UserResponse;
import com.board.board.global.common.response.ApiResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RestController
@RequestMapping("register")
public class RegisterApi {

    private final RegisterService service;

    @PostMapping
    public ApiResponse<UserResponse> register(@RequestBody UserRequest request) {
        return new ApiResponse<>(HttpStatus.CREATED, service.register(request));
    }
}
