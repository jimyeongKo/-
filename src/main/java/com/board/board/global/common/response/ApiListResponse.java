package com.board.board.global.common.response;

import org.springframework.http.HttpStatus;

import java.util.List;

public class ApiListResponse<T> {

    private HttpStatus status;

    private List<T> data;
}
