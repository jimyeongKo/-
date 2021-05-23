package com.board.board.domain.free.api;

import com.board.board.domain.free.application.FreeBoardSearchService;
import com.board.board.domain.free.dto.FreeBoardResponse;
import com.board.board.domain.free.model.FreeBoardType;
import com.board.board.global.common.response.ApiPagingResponse;
import com.board.board.global.common.response.ApiResponse;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RequiredArgsConstructor
@RestController
@RequestMapping("free/search")
public class FreeBoardSearchApi {
    private final FreeBoardSearchService service;

    @GetMapping("/{freeBoardId}")
    public ApiResponse<FreeBoardResponse> findOne(@PathVariable Long freeBoardId) {
        return new ApiResponse<>(HttpStatus.OK, service.findFreeBoard(freeBoardId));
    }

    @GetMapping("/all")
    public ApiPagingResponse<FreeBoardResponse> findAll(@RequestParam int page) {
        return new ApiPagingResponse<>(HttpStatus.OK, service.findAll(page));
    }

    @GetMapping("{type}")
    public ApiPagingResponse<FreeBoardResponse> findType(@RequestParam int page,
                                                         @PathVariable FreeBoardType type) {
        return new ApiPagingResponse<>(HttpStatus.OK, service.findType(page, type));
    }
}
