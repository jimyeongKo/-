package com.board.board.domain.board.dto;


import com.board.board.domain.Image.dto.ImageResponse;
import com.board.board.domain.board.domain.Board;
import com.board.board.domain.comment.dto.ReCommentResponse;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

@Getter
@NoArgsConstructor
public class BoardResponse {
    private Long id;

    private String postContent;

    private String postTitle;

    private String userName;

    private LocalDateTime postDate;

    private List<ReCommentResponse> commentList;

    private List<ImageResponse> imageList;

    public BoardResponse(Board post) {
        this.id = post.getId();
        this.postContent = post.getPostContent();
        this.postTitle = post.getPostTitle();
        this.userName = post.getUser().getUsername();
        this.postDate = post.getPostDate();
        this.imageList = post.getImages().stream().map(ImageResponse::new).collect(Collectors.toList());
        this.commentList = post.getComment().stream().map(ReCommentResponse::new).collect(Collectors.toList());
    }
}
