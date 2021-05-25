package com.board.board.domain.board.domain;

import com.board.board.domain.Image.domain.Image;
import com.board.board.domain.board.dto.BoardRequest;
import com.board.board.domain.comment.domain.Comment;
import com.board.board.domain.user.domain.User;
import lombok.*;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@NoArgsConstructor
@Inheritance(strategy = InheritanceType.JOINED)
//게시판 종류
public class Board {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private LocalDateTime postDate;

    @ManyToOne(fetch = FetchType.LAZY)
    private User user;

    private String content;

    private String title;

    @OneToMany(mappedBy = "board",orphanRemoval = true,cascade = CascadeType.ALL)
    private final List<Image> images = new ArrayList<>();

    @OneToMany(mappedBy = "board",orphanRemoval = true,cascade = CascadeType.ALL)
    private final List<Comment> comment= new ArrayList<>();

    public void addImage(Image image) {
        this.images.add(image);
        image.setBoard(this);
    }

    public void deleteImage(List<Image> image) {
        this.images.remove(image);
    }

    public Board(BoardRequest request, User user) {
        this.title = request.getPostTitle();
        this.content = request.getPostContent();
        this.user = user;
        this.postDate = LocalDateTime.now();
    }

    public Comment lastComment(Board board) {
        int i = board.getComment().size()-1;
        return board.comment.get(i);
    }

    public Image lastImage(Board board) {
        int i = board.getImages().size() -1;
        return board.getImages().get(i);
    }

}
