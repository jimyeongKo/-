package com.board.board.domain.free.application;

import com.board.board.domain.Image.domain.Image;
import com.board.board.domain.board.persistence.BoardRepository;
import com.board.board.domain.free.domain.FreeBoard;
import com.board.board.domain.free.dto.FreeBoardRequest;
import com.board.board.domain.free.dto.FreeBoardResponse;
import com.board.board.domain.free.persistence.FreeBoardRepository;
import com.board.board.domain.user.domain.User;
import com.board.board.global.FileUtil.FileUpload;
import com.board.board.global.error.FileSaveException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class FreeBoardService {

    private final FreeBoardRepository repository;

    public FreeBoardResponse create(FreeBoardRequest request, User user, List<MultipartFile> images) {
        FreeBoard freeBoard = new FreeBoard(request, user);

        repository.save(freeBoard);

        images.forEach(image -> {
            final String IMAGE_LOCATION = "/post/image" + freeBoard.getId() + "/" + image.getOriginalFilename();

            try {
                FileUpload.uploadImage(image, IMAGE_LOCATION);

                Image postImage = Image.create(freeBoard, IMAGE_LOCATION);

                freeBoard.addImage(postImage);
            } catch (Exception e) {
                throw new FileSaveException(image.getOriginalFilename());
            }
        });
        return new FreeBoardResponse(freeBoard);
    }

}
