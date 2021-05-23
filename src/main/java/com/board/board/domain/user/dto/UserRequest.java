package com.board.board.domain.user.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;

@Getter
@NoArgsConstructor
@AllArgsConstructor
public class UserRequest {

    private Long id;

    private String userId;

    private String password;

    private String userName;

    private Long team;

    private String userInfo;

    private int age;

    private String phoneNum;
}
