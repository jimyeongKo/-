package com.board.board.domain.market.persistence;

import com.board.board.domain.market.domain.Market;
import com.board.board.domain.market.model.MarketType;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MarketRepository extends JpaRepository<Market, Long> {

    Page<Market> findByType(MarketType type, Pageable pageable);
}
