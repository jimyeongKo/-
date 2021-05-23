package com.board.board.domain.user.exception;

import com.board.board.global.error.ErrorCode;
import com.board.board.global.error.InvalidValueException;

public class UserNotFoundException extends InvalidValueException {
    public UserNotFoundException(String value) {
        super(value, ErrorCode.CHECK_USER_INVALID);
    }
}
