package com.board.board.domain.notice.application;

import com.board.board.domain.Image.domain.Image;
import com.board.board.domain.market.dto.MarketResponse;
import com.board.board.domain.notice.domain.Notice;
import com.board.board.domain.notice.dto.NoticeRequest;
import com.board.board.domain.notice.dto.NoticeResponse;
import com.board.board.domain.notice.persistence.NoticeRepository;
import com.board.board.domain.user.domain.User;
import com.board.board.global.FileUtil.FileUpload;
import com.board.board.global.error.FileSaveException;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@RequiredArgsConstructor
@Transactional
@Service
@Slf4j
public class NoticeApplyService {

    private final NoticeRepository repository;

    public NoticeResponse createNotice(NoticeRequest request, User user, List<MultipartFile> images) {
        Notice notice = new Notice(request, user);

        repository.save(notice);

        images.forEach(image -> {
            final String IMAGE_LOCATION = "/post/image" + notice.getId() + "/" + image.getOriginalFilename();

            try {
                FileUpload.uploadImage(image, IMAGE_LOCATION);

                Image postImage = Image.create(notice, IMAGE_LOCATION);

                notice.addImage(postImage);
            } catch (Exception e) {
                throw new FileSaveException(image.getOriginalFilename());
            }
        });
        return new NoticeResponse(notice);
    }
}
