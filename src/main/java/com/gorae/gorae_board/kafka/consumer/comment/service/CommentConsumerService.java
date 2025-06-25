package com.gorae.gorae_board.kafka.consumer.comment.service;

import com.gorae.gorae_board.domain.entity.User;
import com.gorae.gorae_board.domain.repository.UserRepository;
import com.gorae.gorae_board.kafka.consumer.comment.dto.AdoptStatusCommentEvent;
import com.gorae.gorae_board.kafka.producer.KafkaMessageProducer;
import com.gorae.gorae_board.kafka.producer.post.dto.UserStatusEvent;
import lombok.RequiredArgsConstructor;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class CommentConsumerService {
    private final UserRepository userRepository;

    private final KafkaMessageProducer kafkaMessageProducer;

    // 채택이 발생했을때 적용되는 서비스
    @Transactional
    public void processAdoptStatusCommentEvent(AdoptStatusCommentEvent event) {
        User user = userRepository.findByUserId((event.getAdoptUserId()))
                .orElseThrow(() -> new RuntimeException("User not found"));

        user.setSelectedCount(user.getSelectedCount()+1);

        // UserBadge 가 최대치일 경우 방어로직
        if (user.getUserBadge() >= 5) {
            user.setUserBadge(5L);
        } else {
            user.setUserBadge(user.getUserBadge() + 1);
        }
//        user.setUserBadge(user.getUserBadge()+1);

        // 메세지 프로듀싱
        UserStatusEvent userStatusEvent = UserStatusEvent.fromEntity(user);
        kafkaMessageProducer.send(UserStatusEvent.TOPIC, userStatusEvent);
    }
}
