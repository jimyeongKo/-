package com.board.board.domain.notice.dto;

import com.board.board.domain.Image.dto.ImageResponse;
import com.board.board.domain.board.dto.BoardResponse;
import com.board.board.domain.notice.domain.Notice;
import com.board.board.domain.notice.model.NoticeBoardType;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.List;

@Getter
@NoArgsConstructor
@AllArgsConstructor
public class NoticeResponse extends BoardResponse {
    private NoticeBoardType type;

    public NoticeResponse(Notice notice) {
        super(notice);
        this.type = notice.getNoticeType();
    }
}
