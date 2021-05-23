package com.board.board.domain.market.dto;

import com.board.board.domain.Image.domain.Image;
import com.board.board.domain.Image.dto.ImageResponse;
import com.board.board.domain.board.domain.Board;
import com.board.board.domain.board.dto.BoardMinResponse;
import com.board.board.domain.comment.domain.Comment;
import com.board.board.domain.comment.dto.ReCommentResponse;
import com.board.board.domain.market.domain.Market;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

@Getter
@NoArgsConstructor
@AllArgsConstructor
public class MarketMinResponse extends BoardMinResponse {
    public MarketMinResponse(Market market) {
        super(market);
    }
}
