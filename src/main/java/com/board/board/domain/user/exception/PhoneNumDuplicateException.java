package com.board.board.domain.user.exception;

import com.board.board.global.error.ErrorCode;
import com.board.board.global.error.InvalidValueException;

public class PhoneNumDuplicateException extends InvalidValueException {
    public PhoneNumDuplicateException(String value) {
        super(value, ErrorCode.PHONENUM_DUPLICATION);
    }
}
