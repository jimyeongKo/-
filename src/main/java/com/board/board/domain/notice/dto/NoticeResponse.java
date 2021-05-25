package com.board.board.domain.notice.dto;

import com.board.board.domain.board.dto.BoardResponse;
import com.board.board.domain.notice.domain.Notice;
import com.board.board.domain.notice.model.NoticeType;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Getter
@NoArgsConstructor
@AllArgsConstructor
public class NoticeResponse{
    private Long id;

    private String postContent;

    private String postTitle;

    private LocalDateTime postDate;

    private NoticeType type;

    public NoticeResponse(Notice notice) {
        this.id = notice.getId();
        this.postContent = notice.getPostContent();
        this.postTitle = notice.getPostTitle();
        this.postDate = notice.getPostDate();
        this.type = notice.getNoticeType();
    }
}
