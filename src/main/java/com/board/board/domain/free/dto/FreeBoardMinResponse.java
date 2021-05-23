package com.board.board.domain.free.dto;

import com.board.board.domain.board.dto.BoardMinResponse;
import com.board.board.domain.free.domain.FreeBoard;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
@AllArgsConstructor
public class FreeBoardMinResponse extends BoardMinResponse {
    public FreeBoardMinResponse(FreeBoard freeBoard) {
        super(freeBoard);
    }
}
