package com.board.board.domain.notice.persistence;

import com.board.board.domain.notice.domain.Notice;
import com.board.board.domain.notice.model.NoticeType;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface NoticeRepository extends JpaRepository<Notice, Long> {
    List<Notice> findByNoticeType(NoticeType type);
}
