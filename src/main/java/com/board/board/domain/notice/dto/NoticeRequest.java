package com.board.board.domain.notice.dto;

import com.board.board.domain.board.dto.BoardRequest;
import com.board.board.domain.notice.model.NoticeType;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
@AllArgsConstructor
public class NoticeRequest extends BoardRequest {

    private NoticeType noticeType;
}
