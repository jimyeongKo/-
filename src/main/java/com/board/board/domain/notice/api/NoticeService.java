package com.board.board.domain.notice.api;

import com.board.board.domain.notice.application.NoticeApplyService;
import com.board.board.domain.notice.application.NoticeSearchService;
import com.board.board.domain.notice.dto.NoticeRequest;
import com.board.board.domain.notice.dto.NoticeResponse;
import com.board.board.domain.notice.model.NoticeType;
import com.board.board.domain.user.domain.User;
import com.board.board.global.common.response.ApiListResponse;
import com.board.board.global.common.response.ApiResponse;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.*;

@Slf4j
@RequiredArgsConstructor
@RestController
@RequestMapping("notice")
public class NoticeService {

    private final NoticeApplyService applyService;
    private final NoticeSearchService searchService;

    @PostMapping
    public ApiResponse<NoticeResponse> create(@RequestBody NoticeRequest request
            , @AuthenticationPrincipal User user)
    {
        return new ApiResponse<>(HttpStatus.CREATED, applyService.createNotice(request, user));
    }

    @GetMapping("{type}")
    public ApiListResponse<NoticeResponse> searchNotice(@PathVariable NoticeType type) {
        return new ApiListResponse<>(HttpStatus.OK, searchService.searchNotice(type));
    }

    @GetMapping("{noticeId}")
    public ApiResponse<NoticeResponse> noticeDetail(@PathVariable Long noticeId) {
        return new ApiResponse<>(HttpStatus.OK, searchService.noticeDetail(noticeId));
    }

}
