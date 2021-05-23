package com.board.board.domain.user.dto;

import com.board.board.domain.user.domain.Team;
import com.board.board.domain.user.domain.User;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;

import javax.persistence.Column;
import javax.persistence.FetchType;
import javax.persistence.ManyToOne;

@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class UserResponse {
    private Long id;

    private String userId;

    private String password;

    private String userName;

    private String teamName;

    private String userInfo;

    private int age;

    private String phoneNum;

    public UserResponse(final User user) {
        this.id = user.getId();
        this.userId = user.getUserId();
        this.password = user.getPassword();
        this.userName = user.getUsername();
        this.teamName = user.getTeam().getTeamName();
        this.userInfo = user.getUserInfo();
        this.age = user.getAge();
        this.phoneNum = user.getPhoneNum();

    }
}
