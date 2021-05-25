package com.board.board.domain.notice.application;

import com.board.board.domain.board.exception.BoardNotFoundException;
import com.board.board.domain.notice.domain.Notice;
import com.board.board.domain.notice.dto.NoticeResponse;
import com.board.board.domain.notice.model.NoticeType;
import com.board.board.domain.notice.persistence.NoticeRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
@Slf4j
@Transactional(readOnly = true)
public class NoticeSearchService {

    private final NoticeRepository repository;

    // 공지사항 타입별로 보기
    public List<NoticeResponse> searchNotice(NoticeType type) {
        List<Notice> notice = repository.findByNoticeType(type);

        List<NoticeResponse> data = notice.stream().map(NoticeResponse::new).collect(Collectors.toList());

        return data;
    }

    // 공지사항 상세보기
    public NoticeResponse noticeDetail(Long noticeId) {
        Notice notice = repository.findById(noticeId).orElse(null);

        if (notice == null) {
            throw new BoardNotFoundException(noticeId.toString());
        }

        return new NoticeResponse(notice);
    }

}
