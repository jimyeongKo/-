package com.board.board.domain.Image.persistence;

import com.board.board.domain.Image.domain.Image;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ImageRepository extends JpaRepository<Image, Long> {
    List<Image> findByBoardId(Long id);
}
