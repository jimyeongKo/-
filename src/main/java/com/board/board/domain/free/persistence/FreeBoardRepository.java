package com.board.board.domain.free.persistence;

import com.board.board.domain.free.domain.FreeBoard;
import com.board.board.domain.free.model.FreeBoardType;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FreeBoardRepository extends JpaRepository<FreeBoard, Long> {
    Page<FreeBoard> findByFreeBoardType(FreeBoardType type, Pageable pageable);
}
