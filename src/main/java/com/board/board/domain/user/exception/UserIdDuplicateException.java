package com.board.board.domain.user.exception;

import com.board.board.global.error.ErrorCode;
import com.board.board.global.error.InvalidValueException;

public class UserIdDuplicateException extends InvalidValueException {
    public UserIdDuplicateException(String value) {
        super(value, ErrorCode.USERID_DUPLICATION);
    }
}
