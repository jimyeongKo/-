package com.board.board.domain.comment.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.annotation.security.DenyAll;

@Getter
@NoArgsConstructor
@AllArgsConstructor
public class CommentRequest {

    private Long parent;

    private String commentContent;
}
