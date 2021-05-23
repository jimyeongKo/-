package com.board.board.domain.board.exception;

import com.board.board.domain.board.domain.Board;
import com.board.board.global.error.ErrorCode;
import com.board.board.global.error.InvalidValueException;

public class BoardNotFoundException extends InvalidValueException {
    public BoardNotFoundException(String value, ErrorCode errorCode) {
        super(value, errorCode);
    }
    public BoardNotFoundException(String value) {
        super(value, ErrorCode.BOARD_NOT_FOUND);
    }

}
