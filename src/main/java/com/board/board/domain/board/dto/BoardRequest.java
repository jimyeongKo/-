package com.board.board.domain.board.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.List;

@Getter
@NoArgsConstructor
public class BoardRequest {

    private String postContent;

    private String postTitle;

}
