package com.board.board.domain.board.api;

import com.board.board.domain.board.application.BoardService;
import com.board.board.domain.board.dto.BoardResponse;
import com.board.board.global.common.response.ApiResponse;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RestController
@RequestMapping("board")
@Slf4j
public class BoardApi {

    private final BoardService service;

    @DeleteMapping("{boardId}")
    public ApiResponse<BoardResponse> delete(@PathVariable Long boardId) {
        return new ApiResponse<>(HttpStatus.OK, service.deleteBoard(boardId));
    }

}
