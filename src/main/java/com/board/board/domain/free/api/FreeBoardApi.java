package com.board.board.domain.free.api;

import com.board.board.domain.free.application.FreeBoardService;
import com.board.board.domain.free.dto.FreeBoardRequest;
import com.board.board.domain.free.dto.FreeBoardResponse;
import com.board.board.domain.user.domain.User;
import com.board.board.global.common.response.ApiResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("board/free")
public class FreeBoardApi {

    private final FreeBoardService service;

    @PostMapping()
    public ApiResponse<FreeBoardResponse> create(@RequestPart FreeBoardRequest request,
                                                 @AuthenticationPrincipal User user, @RequestPart List<MultipartFile> image) {
        return new ApiResponse<>(HttpStatus.CREATED, service.create(request, user, image));
    }
}
