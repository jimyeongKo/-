package com.board.board.domain.user.persistence;

import com.board.board.domain.user.domain.Team;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TeamRepository extends JpaRepository<Team, Long> {
}
