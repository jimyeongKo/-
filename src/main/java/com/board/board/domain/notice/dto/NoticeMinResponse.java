package com.board.board.domain.notice.dto;

import com.board.board.domain.board.dto.BoardMinResponse;
import com.board.board.domain.notice.domain.Notice;

public class NoticeMinResponse extends BoardMinResponse {
    public NoticeMinResponse(Notice noticeBoard) {
        super(noticeBoard);
    }
}
