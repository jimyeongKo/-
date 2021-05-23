package com.board.board.domain.market.dto;

import com.board.board.domain.board.dto.BoardResponse;
import com.board.board.domain.market.domain.Market;
import com.board.board.domain.market.model.MarketType;

public class MarketResponse extends BoardResponse {

    private MarketType type;

    public MarketResponse(Market market) {
        super(market);
        this.type = market.getType();
    }
}
