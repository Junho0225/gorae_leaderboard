package com.gorae.gorae_board.kafka.consumer.comment.service;

import com.gorae.gorae_board.domain.entity.User;
import com.gorae.gorae_board.domain.repository.UserRepository;
import com.gorae.gorae_board.kafka.consumer.comment.dto.AdoptStatusCommentEvent;
import com.gorae.gorae_board.kafka.consumer.comment.dto.CommentEvent;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor


public class CommentEventConsumerService {
    private final UserRepository userRepository;

    @Transactional
    public void processCommentStatusEvent(CommentEvent event) {
        User user = userRepository.findByUserId((event.getCommentUserId()))
                .orElseThrow(() -> new RuntimeException("User not found"));
        user.setCommentCount(user.getCommentCount()+1);
    }
}
