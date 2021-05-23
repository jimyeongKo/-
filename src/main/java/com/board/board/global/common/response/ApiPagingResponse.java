package com.board.board.global.common.response;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.http.HttpStatus;

@Getter
@NoArgsConstructor
@AllArgsConstructor
public class ApiPagingResponse<T> {

    private HttpStatus status;

    private PagingResponse<T> data;
}
