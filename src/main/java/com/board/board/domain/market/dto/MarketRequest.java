package com.board.board.domain.market.dto;

import com.board.board.domain.board.dto.BoardRequest;
import com.board.board.domain.market.model.MarketType;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
@AllArgsConstructor
public class MarketRequest extends BoardRequest {
    private MarketType type;
}
