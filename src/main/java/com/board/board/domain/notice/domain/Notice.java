package com.board.board.domain.notice.domain;

import com.board.board.domain.board.domain.Board;
import com.board.board.domain.notice.dto.NoticeRequest;
import com.board.board.domain.notice.model.NoticeBoardType;
import com.board.board.domain.user.domain.User;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Entity;

@Getter
@Entity
@NoArgsConstructor
@Setter
public class Notice extends Board {
    private NoticeBoardType noticeType;

    public Notice(NoticeRequest request, User user) {
        super(request, user);
        this.noticeType = request.getNoticeType();
    }
}
