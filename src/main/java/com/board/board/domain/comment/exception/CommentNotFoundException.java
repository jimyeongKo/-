package com.board.board.domain.comment.exception;

import com.board.board.global.error.ErrorCode;
import com.board.board.global.error.InvalidValueException;
import org.springframework.web.multipart.commons.CommonsMultipartFile;

public class CommentNotFoundException extends InvalidValueException {
    public CommentNotFoundException(String value) {
        super(value, ErrorCode.COMMENT_NOT_FOUND);
    }

}
