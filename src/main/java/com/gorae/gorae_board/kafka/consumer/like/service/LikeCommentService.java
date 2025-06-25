package com.gorae.gorae_board.kafka.consumer.like.service;

import com.gorae.gorae_board.domain.entity.User;
import com.gorae.gorae_board.domain.repository.UserRepository;
import com.gorae.gorae_board.kafka.consumer.like.dto.LikeStatusEvent;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import lombok.Getter;
import lombok.Setter;

@Service
@RequiredArgsConstructor
public class LikeCommentService {

    private final UserRepository userRepository;

    @Transactional
    public void processCommentLike(LikeStatusEvent event) {
        User user = userRepository.findById(event.getCommentLikeUserId())
                .orElseThrow(() -> new IllegalArgumentException("User not found"));

        Long likeCount = user.getLikeCount();
        user.setLikeCount(likeCount + 1);
        user.setLikeBadge(Long.toString(Long.parseLong((user.getLikeBadge())+1)));
    }

    @Transactional
    public void processCommentLikeCancel(LikeStatusEvent event) {
        User user = userRepository.findById(event.getCommentLikeUserId())
                .orElseThrow(() -> new IllegalArgumentException("User not found"));

        Long likeCount = user.getLikeCount();
        user.setLikeCount(Math.max(0, likeCount - 1));
    }
}