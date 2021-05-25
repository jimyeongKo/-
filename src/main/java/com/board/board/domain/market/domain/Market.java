package com.board.board.domain.market.domain;

import com.board.board.domain.board.domain.Board;
import com.board.board.domain.market.dto.MarketRequest;
import com.board.board.domain.market.model.MarketStatus;
import com.board.board.domain.market.model.MarketType;
import com.board.board.domain.user.domain.User;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;

@Getter
@Entity
@NoArgsConstructor
public class Market extends Board {

    private MarketType type;

    private MarketStatus status;

    public Market(MarketRequest request, User user) {
        super(request, user);
        this.type = request.getType();
        this.status = MarketStatus.WAIT;
    }
}
