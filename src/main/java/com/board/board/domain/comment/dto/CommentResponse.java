package com.board.board.domain.comment.dto;

import com.board.board.domain.comment.domain.Comment;
import com.board.board.domain.user.domain.User;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Getter
@AllArgsConstructor
@NoArgsConstructor
public class CommentResponse {

    private Long id;

    private String content;

    private LocalDateTime createTime;

    private String userName;


    public CommentResponse(Comment comment) {
        this.id = comment.getId();
        this.content = comment.getCommentContent();
        this.createTime = comment.getCommentDate();
        this.userName = comment.getUser().getUsername();
    }
}
