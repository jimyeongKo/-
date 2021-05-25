package com.board.board.domain.market.application;

import com.board.board.domain.board.exception.BoardNotFoundException;
import com.board.board.domain.market.domain.Market;
import com.board.board.domain.market.dto.MarketMinResponse;
import com.board.board.domain.market.dto.MarketResponse;
import com.board.board.domain.market.model.MarketStatus;
import com.board.board.domain.market.model.MarketType;
import com.board.board.domain.market.persistence.MarketRepository;
import com.board.board.global.common.response.PagingResponse;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
@Transactional(readOnly = true)
@RequiredArgsConstructor
@Slf4j
public class MarketSearchService {

    private final MarketRepository repository;

    // 상세보기
    public MarketResponse findById(Long marketId) {
        Market market = repository.findById(marketId).orElse(null);
        if (market == null) {
            throw new BoardNotFoundException(marketId.toString());
        }

        return new MarketResponse(market);
    }

    // 마켓 전체 보기
    public PagingResponse<MarketMinResponse> findAll(int page, MarketStatus status) {
        if (status == null) {
            Page<Market> markets = repository.findAll(paging(page));

            List<MarketMinResponse> data = markets.getContent().stream().map(MarketMinResponse::new).collect(Collectors.toList());

            return new PagingResponse<>(page, markets.getTotalPages(), markets.getTotalElements(), data);
        }
        // 거래 상태별 보기
        Page<Market> markets = repository.findByStatus(MarketStatus.WAIT, paging(page));

        List<MarketMinResponse> data = markets.getContent().stream().map(MarketMinResponse::new).collect(Collectors.toList());

        return new PagingResponse<>(page, markets.getTotalPages(), markets.getTotalElements(), data);
    }

    // 마켓 타입별 보기
    public PagingResponse<MarketMinResponse> findType(int page, MarketType type, MarketStatus status) {

        if (status == null) {
            Page<Market> markets = repository.findByType(type, paging(page));

            List<MarketMinResponse> data  = markets.getContent().stream().map(MarketMinResponse::new).collect(Collectors.toList());

            return new PagingResponse<>(page, markets.getTotalPages(), markets.getTotalElements(), data);
        }
        // 거래 상태별 보기
        Page<Market> markets = repository.findByStatusAndType(status, type, paging(page));

        List<MarketMinResponse> data = markets.getContent().stream().map(MarketMinResponse::new).collect(Collectors.toList());

        return new PagingResponse<>(page, markets.getTotalPages(), markets.getTotalElements(), data);
    }

    public Pageable paging(int page) {
    return PageRequest.of(page, 10, Sort.Direction.DESC, "postDate");
    }
}
