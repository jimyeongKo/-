package com.board.board.domain.user.application;

import com.board.board.domain.user.domain.User;
import com.board.board.domain.user.dto.TokenResponse;
import com.board.board.domain.user.persistence.UserRepository;
import com.board.board.global.security.JwtTokenProvider;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class UserService {

    private final JwtTokenProvider jwtTokenProvider;

    private final
    UserRepository repository;

    // 자기 정보 불러오기(토큰 리프레쉬용)
    public TokenResponse me(User user) {
        User me = repository.findById(user.getId()).orElseThrow();

        String token = jwtTokenProvider.createToken(String.valueOf(me.getId()), me.getRoles());

        return new TokenResponse(token, me);
    }
}
