package com.gorae.gorae_board.service;

import com.gorae.gorae_board.domain.dto.LeaderBoardDto;
import com.gorae.gorae_board.domain.entity.Leaderboard;
import com.gorae.gorae_board.domain.repository.LeaderboardRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.awt.print.Pageable;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor

public class LeaderboardService {

    private final LeaderboardRepository leaderboardRepository;


    public void registerUser(Long userId, String username) {
        Leaderboard lb = new Leaderboard();
        lb.setUserId(userId);
        lb.setUsername(username);
        lb.setRecommendPoint(0L);
        lb.setQuestionCount(0L);
        leaderboardRepository.save(lb);
    }
}

