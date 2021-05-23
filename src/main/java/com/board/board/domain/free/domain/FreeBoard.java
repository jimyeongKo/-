package com.board.board.domain.free.domain;

import com.board.board.domain.board.domain.Board;
import com.board.board.domain.free.dto.FreeBoardRequest;
import com.board.board.domain.free.model.FreeBoardType;
import com.board.board.domain.user.domain.User;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;

@Getter
@Entity
@NoArgsConstructor
public class FreeBoard extends Board {

    private FreeBoardType freeBoardType;

    public FreeBoard(FreeBoardRequest request, User user) {
        super(request, user);
        this.freeBoardType = request.getType();
    }
}
