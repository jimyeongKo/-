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

    public NoticeResponse createNotice(NoticeRequest request, User user) {
        Notice notice = new Notice(request, user);

        repository.save(notice);

        return new NoticeResponse(notice);
    }
}
