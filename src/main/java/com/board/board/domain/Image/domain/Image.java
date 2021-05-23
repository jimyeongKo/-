package com.board.board.domain.Image.domain;

import com.board.board.domain.board.domain.Board;
import lombok.*;

import javax.persistence.*;

@Getter
@Entity
@NoArgsConstructor
@Builder
@AllArgsConstructor
@Setter
public class Image {

    @Id
    @GeneratedValue
    private Long Id;

    @ManyToOne(fetch = FetchType.LAZY)
    private Board board;

    @Column(nullable = false)
    private String path;


    public static Image create(Board board, String path){

        return Image.builder()
                .board(board)
                .path(path).build();
    }

}
