package com.board.board.domain.comment.application;

import com.board.board.domain.board.domain.Board;
import com.board.board.domain.board.exception.BoardNotFoundException;
import com.board.board.domain.board.persistence.BoardRepository;
import com.board.board.domain.comment.domain.Comment;
import com.board.board.domain.comment.dto.CommentRequest;
import com.board.board.domain.comment.dto.CommentResponse;
import com.board.board.domain.comment.exception.CommentNotFoundException;
import com.board.board.domain.comment.persistence.CommentRepository;
import com.board.board.domain.user.domain.User;
import com.board.board.domain.user.exception.NotMyEntityException;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.validation.constraints.Size;

@Service
@RequiredArgsConstructor
@Slf4j
@Transactional
public class CommentApplyService {

    private final CommentRepository repository;

    private final BoardRepository boardRepository;

    // 댓글 달기
    public CommentResponse create(Long boardId, User user,CommentRequest request) {
        Board board = boardRepository.findById(boardId).orElse(null);
        if (board == null) {
            throw new BoardNotFoundException(boardId.toString());
        }

        Comment comment = Comment.create(request
                , board, user
                , request.getParent() != null ? repository.findById(request.getParent()).orElse(null) : null);

        return new CommentResponse(repository.save(comment));
    }

    public CommentResponse Update(Long commentId, CommentRequest request, User user) {
        Comment comment = repository.findById(commentId).orElse(null);
        if (comment == null) {
            throw new CommentNotFoundException(commentId.toString());
        }
        if (comment.getUser().getId() != user.getId()) {
            throw new NotMyEntityException(user.getUserId().toString());
        }

        comment.update(request);

        return new CommentResponse(repository.save(comment));
    }
}
