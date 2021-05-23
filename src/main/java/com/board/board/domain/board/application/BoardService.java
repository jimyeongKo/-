package com.board.board.domain.board.application;

import com.board.board.domain.Image.domain.Image;
import com.board.board.domain.Image.persistence.ImageRepository;
import com.board.board.domain.board.domain.Board;
import com.board.board.domain.board.dto.BoardResponse;
import com.board.board.domain.board.exception.BoardNotFoundException;
import com.board.board.domain.board.persistence.BoardRepository;
import com.board.board.global.FileUtil.FileUpload;
import lombok.RequiredArgsConstructor;
import org.hibernate.annotations.SelectBeforeUpdate;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
@Transactional
public class BoardService {

    private final BoardRepository repository;
    private final ImageRepository imageRepository;

    public BoardResponse deleteBoard(Long boardId) {
        Board board = repository.findById(boardId).orElseThrow();

        List<Image> image = imageRepository.findByBoardId(board.getId());
        repository.delete(board);
        board.deleteImage(image);
        for (Image value : image) {
            FileUpload.deleteFile(value.getPath());
        }

        return new BoardResponse(board);
    }


}
