package com.board.board.domain.free.dto;

import com.board.board.domain.board.dto.BoardResponse;
import com.board.board.domain.free.domain.FreeBoard;
import com.board.board.domain.free.model.FreeBoardType;

public class FreeBoardResponse extends BoardResponse {

    private FreeBoardType freeBoardType;

    public FreeBoardResponse(FreeBoard freeBoard) {
        super(freeBoard);
        this.freeBoardType = freeBoard.getFreeBoardType();
    }
}
