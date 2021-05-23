package com.board.board.domain.user.exception;

import com.board.board.global.error.ErrorCode;
import com.board.board.global.error.InvalidValueException;

public class PasswordNotMatchException extends InvalidValueException {
    public PasswordNotMatchException(String value) {
        super(value, ErrorCode.PASSWORD_INPUT_INVALID);
    }

}
