package com.board.board.domain.market.dto;

import com.board.board.domain.board.dto.BoardResponse;
import com.board.board.domain.market.domain.Market;
import com.board.board.domain.market.model.MarketStatus;
import com.board.board.domain.market.model.MarketType;

import javax.xml.bind.Marshaller;

public class MarketResponse extends BoardResponse {

    private MarketType type;

    private MarketStatus status;
    public MarketResponse(Market market) {
        super(market);
        this.type = market.getType();
        this.status = market.getStatus();
    }
}
