package com.board.board.global.error;

public class FileSaveException extends InvalidValueException{
    public FileSaveException(String value) {
        super(value, ErrorCode.FILE_SAVE_ERROR);
    }
}
