package com.board.board.domain.Image.dto;

import com.board.board.domain.Image.domain.Image;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.imageio.ImageReader;

@Getter
@NoArgsConstructor
@AllArgsConstructor
public class ImageResponse {
    private Long id;

    private String path;

    public ImageResponse(Image image) {
        this.id = image.getId();
        this.path = image.getPath();
    }
}
