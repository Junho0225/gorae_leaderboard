package com.gorae.gorae_board.kafka.consumer.like.service;

import com.gorae.gorae_board.domain.entity.User;
import com.gorae.gorae_board.domain.repository.UserRepository;
import com.gorae.gorae_board.kafka.consumer.like.dto.LikeStatusEvent;
import com.gorae.gorae_board.kafka.producer.KafkaMessageProducer;
import com.gorae.gorae_board.kafka.producer.post.dto.UserStatusEvent;
import jakarta.transaction.Transactional;
import jakarta.transaction.UserTransaction;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import lombok.Getter;
import lombok.Setter;

@Service
@RequiredArgsConstructor
public class LikeCommentService {

    private final UserRepository userRepository;

    private final KafkaMessageProducer kafkaMessageProducer;
    @Transactional
    public void processCommentLike(LikeStatusEvent event) {
        // 좋아요가 발생했을때 적용되는 서비스
        User user = userRepository.findById(event.getCommentLikeUserId())
                .orElseThrow(() -> new IllegalArgumentException("User not found"));

        Long likeCount = user.getLikeCount();
        user.setLikeCount(likeCount + 1);

        // 좋야요 뱃지가 최대치일 경우 방어로직
        if (user.getLikeBadge() >= 5) {
            user.setLikeBadge(5L);
        } else {
            user.setLikeBadge(user.getLikeBadge() + 1);
        }

        UserStatusEvent userStatusEvent = UserStatusEvent.fromEntity(user);
        kafkaMessageProducer.send(UserStatusEvent.TOPIC, userStatusEvent);
    }

    @Transactional
    public void processCommentLikeCancel(LikeStatusEvent event) {
        User user = userRepository.findById(event.getCommentLikeUserId())
                .orElseThrow(() -> new IllegalArgumentException("User not found"));

        Long likeCount = user.getLikeCount();
        user.setLikeCount(Math.max(0, likeCount - 1));
    }
}