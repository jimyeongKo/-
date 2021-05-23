package com.board.board.domain.free.application;

import com.board.board.domain.board.exception.BoardNotFoundException;
import com.board.board.domain.free.domain.FreeBoard;
import com.board.board.domain.free.dto.FreeBoardResponse;
import com.board.board.domain.free.model.FreeBoardType;
import com.board.board.domain.free.persistence.FreeBoardRepository;
import com.board.board.domain.user.exception.UserNotFoundException;
import com.board.board.global.common.response.PagingResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class FreeBoardSearchService {

    private final FreeBoardRepository repository;

    // 자유게시판 하나 보기
    public FreeBoardResponse findFreeBoard(Long freeBoardId) {
        Optional<FreeBoard> freeBoard = repository.findById(freeBoardId);

        if (!freeBoard.isPresent()) {
            throw new BoardNotFoundException(freeBoard.toString());
        }
        return new FreeBoardResponse(freeBoard.get());
    }

    // 자유게시판 전체 보기
    public PagingResponse<FreeBoardResponse> findAll(int page) {
        Page<FreeBoard> freeBoard = repository.findAll(PageRequest.of(page, 10, Sort.Direction.DESC, "CreateAt"));

        List<FreeBoardResponse> data = freeBoard.getContent().stream().map(FreeBoardResponse::new).collect(Collectors.toList());

        return new PagingResponse<>(page, freeBoard.getTotalPages(), freeBoard.getTotalElements(), data);
    }

    // 타입 별 paging 처리
    public PagingResponse<FreeBoardResponse> findType(int page, FreeBoardType freeBoardType) {
        Page<FreeBoard> freeBoard = repository.findByFreeBoardType(freeBoardType, PageRequest.of(page, 10, Sort.Direction.DESC, "CreateAt"));

        List<FreeBoardResponse> data = freeBoard.getContent().stream().map(FreeBoardResponse::new).collect(Collectors.toList());

        return new PagingResponse<>(page, freeBoard.getTotalPages(), freeBoard.getTotalElements(), data);
    }

}
