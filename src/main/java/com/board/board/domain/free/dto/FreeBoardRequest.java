package com.board.board.domain.free.dto;


import com.board.board.domain.board.dto.BoardRequest;
import com.board.board.domain.free.model.FreeBoardType;
import lombok.Getter;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Getter
public class FreeBoardRequest extends BoardRequest {
    FreeBoardType type;
}
