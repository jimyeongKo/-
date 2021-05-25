package com.board.board.domain.comment.api;

import com.board.board.domain.comment.application.CommentApplyService;
import com.board.board.domain.comment.dto.CommentRequest;
import com.board.board.domain.comment.dto.CommentResponse;
import com.board.board.domain.user.domain.User;
import com.board.board.global.common.response.ApiResponse;
import lombok.RequiredArgsConstructor;
import org.hibernate.loader.plan.build.internal.LoadGraphLoadPlanBuildingStrategy;
import org.springframework.http.HttpStatus;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("comment")
public class CommentApi {

    private final CommentApplyService applyService;

    @PostMapping("/{boardId}")
    public ApiResponse<CommentResponse> createComment(@AuthenticationPrincipal User user,
                                                     @RequestBody CommentRequest request,
                                                     @PathVariable Long boardId)
    {
        return new ApiResponse<>(HttpStatus.CREATED, applyService.create(boardId, user, request));
    }

    @PatchMapping("/{commentId}")
    public ApiResponse<CommentResponse> updateComment(@AuthenticationPrincipal User user,
                                                      @PathVariable Long commentId,
                                                      @RequestBody CommentRequest request)
    {
        return new ApiResponse<>(HttpStatus.OK, applyService.Update(commentId, request, user));
    }

}
