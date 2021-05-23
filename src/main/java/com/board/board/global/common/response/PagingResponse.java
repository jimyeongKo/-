package com.board.board.global.common.response;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.http.HttpStatus;

import java.util.List;

@Getter
@AllArgsConstructor
@NoArgsConstructor
public class PagingResponse<T> {
    private int page;

    private int totalPage;

    private Long totalCount;

    private List<T> data;
}
