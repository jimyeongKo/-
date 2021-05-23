package com.board.board.domain.comment.dto;

import com.board.board.domain.comment.domain.Comment;
import com.board.board.domain.user.domain.User;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.List;
import java.util.stream.Collectors;

@Getter
@NoArgsConstructor
@AllArgsConstructor
public class ReCommentResponse extends CommentResponse {
    private List<CommentResponse> children;

    public ReCommentResponse(Comment comment) {
        super(comment);
        this.children = comment.getChildren().stream().map(CommentResponse::new).collect(Collectors.toList());
    }
}
