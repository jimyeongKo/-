package com.board.board.domain.board.dto;

import com.board.board.domain.Image.domain.Image;
import com.board.board.domain.board.domain.Board;
import com.board.board.domain.comment.domain.Comment;
import com.board.board.domain.market.domain.Market;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@NoArgsConstructor
@AllArgsConstructor
@Getter
public class BoardMinResponse {
    private String postContent;

    private String postTitle;

    private String userName;

    private LocalDateTime postDate;

    private Comment lastComment;

    private Image lastImage;

    public BoardMinResponse(Board board) {
        this.postContent = board.getPostContent();
        this.postTitle = board.getPostTitle();
        this.userName = board.getUser().getUsername();
        this.postDate = board.getPostDate();
        this.lastImage = board.lastImage(board);
        this.lastComment = board.lastComment(board);
    }
}
