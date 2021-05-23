package com.board.board.domain.comment.domain;


import com.board.board.domain.board.domain.Board;
import com.board.board.domain.comment.dto.CommentRequest;
import com.board.board.domain.user.domain.User;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Getter
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Comment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long Id;

    private LocalDateTime commentDate;

    @ManyToOne(fetch = FetchType.LAZY)
    private Comment parent;

    @OneToMany(mappedBy = "parent" ,cascade = CascadeType.ALL,orphanRemoval = true)
    private final List<Comment> children = new ArrayList<>();

    @ManyToOne(fetch = FetchType.LAZY)
    private Board board;

    @ManyToOne(fetch = FetchType.LAZY)
    private User user;

    private String commentContent;


    public static Comment create(CommentRequest dto, Board board, Comment parent){

        return Comment.builder().commentDate(LocalDateTime.now())
                .parent(parent)
                .board(board)
                .commentContent(dto.getCommentContent())
                .build();
    }

    public void update(CommentRequest dto){

        this.commentContent =dto.getCommentContent();
    }


}
