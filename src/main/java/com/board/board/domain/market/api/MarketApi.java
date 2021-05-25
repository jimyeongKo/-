package com.board.board.domain.market.api;

import com.board.board.domain.market.application.MarketApplyService;
import com.board.board.domain.market.application.MarketSearchService;
import com.board.board.domain.market.dto.MarketMinResponse;
import com.board.board.domain.market.dto.MarketRequest;
import com.board.board.domain.market.dto.MarketResponse;
import com.board.board.domain.market.model.MarketStatus;
import com.board.board.domain.market.model.MarketType;
import com.board.board.domain.user.domain.User;
import com.board.board.global.common.response.ApiPagingResponse;
import com.board.board.global.common.response.ApiResponse;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@RestController
@RequiredArgsConstructor
@Slf4j
@RequestMapping("market")
public class MarketApi {
    private final MarketApplyService applyService;

    private final MarketSearchService searchService;


    @PostMapping
    public ApiResponse<MarketResponse> create(@RequestPart(name = "market") MarketRequest request,
                                              @RequestPart(name = "image") List<MultipartFile> images,
                                              @AuthenticationPrincipal User user) {
        return new ApiResponse<>(HttpStatus.OK, applyService.createMarket(request, user, images));
    }

    @GetMapping("/all/{status}")
    public ApiPagingResponse<MarketMinResponse> all(@RequestParam int page, @PathVariable MarketStatus status) {
        return new ApiPagingResponse<>(HttpStatus.OK, searchService.findAll(page, status));
    }

    @GetMapping("{type}/{status}")
    public ApiPagingResponse<MarketMinResponse> typeSearch(@RequestParam int page
            , @PathVariable MarketType type
            , @PathVariable MarketStatus status) {
        return new ApiPagingResponse<>(HttpStatus.OK, searchService.findType(page, type, status));
    }

    @GetMapping("{marketId}")
    public ApiResponse<MarketResponse> detailMarket(@PathVariable Long marketId) {
        return new ApiResponse<>(HttpStatus.OK, searchService.findById(marketId));
    }
}
