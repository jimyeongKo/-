package com.board.board.domain.user.application;

import com.board.board.domain.user.domain.Team;
import com.board.board.domain.user.domain.User;
import com.board.board.domain.user.dto.UserRequest;
import com.board.board.domain.user.dto.UserResponse;
import com.board.board.domain.user.exception.PhoneNumDuplicateException;
import com.board.board.domain.user.exception.UserIdDuplicateException;
import com.board.board.domain.user.persistence.TeamRepository;
import com.board.board.domain.user.persistence.UserRepository;
import com.board.board.global.security.JwtTokenProvider;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Slf4j
@Service
@RequiredArgsConstructor
@Transactional
public class RegisterService {

    private final JwtTokenProvider jwtTokenProvider;
    private final PasswordEncoder passwordEncoder;

    private final UserRepository repository;
    private final TeamRepository teamRepository;

    public UserResponse register(UserRequest request) {
        checkPhoneNum(request.getPhoneNum());
        checkUserIdDuplicate(request.getUserId());

        Team team = teamRepository.findById(request.getTeam()).get();
        User user = User.create(request,passwordEncoder.encode(request.getPassword()), team);

        repository.save(user);

        return new UserResponse(user);
    }

    /*
    유저 아이디가 이미 존재하는지 확인
     */
    public Boolean checkUserIdDuplicate(String userId) {
        Boolean check = repository.existsByUserId(userId);
        if (check.equals(true)) throw new UserIdDuplicateException(userId);
        return check;
    }

    /*
    핸드폰 번호로 이미 회원 가입한 유저가 있는지 확인인
     */
    public Boolean checkPhoneNum(String phoneNum) {
        Boolean check = repository.existsByPhoneNum(phoneNum);
        if (check.equals(true)) throw new PhoneNumDuplicateException(phoneNum);
        return check;
    }
}
