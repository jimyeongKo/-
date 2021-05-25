package com.board.board.domain.user.exception;

import com.board.board.global.error.ErrorCode;
import com.board.board.global.error.InvalidValueException;

public class NotMyEntityException extends InvalidValueException {

    public NotMyEntityException(String value) {
        super(value, ErrorCode.NOT_MY_ENTITY);
    }
}
