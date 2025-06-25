package com.gorae.gorae_board.domain.repository;

import com.gorae.gorae_board.domain.entity.Leaderboard;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.awt.print.Pageable;
import java.util.List;
import java.util.Optional;

@Repository

public interface LeaderboardRepository extends JpaRepository<Leaderboard, Long> {
    Optional<Leaderboard> findByUserId(Long userId);

}