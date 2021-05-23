package com.board.board.global.error;

public class FileNotFoundException extends InvalidValueException{

    public FileNotFoundException(String value) {
        super(value, ErrorCode.FILE_NOT_FOUND);
    }
}
