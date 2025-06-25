package com.gorae.gorae_board.kafka.consumer.comment.service;

import com.gorae.gorae_board.domain.entity.User;
import com.gorae.gorae_board.domain.repository.UserRepository;
import com.gorae.gorae_board.kafka.consumer.comment.dto.AdoptStatusCommentEvent;
import lombok.RequiredArgsConstructor;
import org.springframework.transaction.annotation.Transactional;

@RequiredArgsConstructor
public class CommentConsumerService {
    private final UserRepository userRepository;

    @Transactional
    public void processAdoptStatusCommentEvent(AdoptStatusCommentEvent event) {
        User user = userRepository.findByUserId(Long.valueOf(event.getAdoptUserId()))
                .orElseThrow(() -> new RuntimeException("User not found"));
        user.setSelectedCount(Long.toString(Long.valueOf(user.getSelectedCount())+1));
        user.setUserBadge(Long.toString(Long.valueOf(user.getUserBadge())+1));
    }
}
