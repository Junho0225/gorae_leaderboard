package com.gorae.gorae_board.kafka.consumer.like;

import com.gorae.gorae_board.kafka.consumer.like.dto.LikeStatusEvent;
import com.gorae.gorae_board.kafka.consumer.like.service.LikeCommentService;
import com.gorae.gorae_board.kafka.consumer.user.dto.UserLeaderBoardEvent;
import com.gorae.gorae_board.kafka.consumer.user.service.UserService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.support.Acknowledgment;
import org.springframework.kafka.support.serializer.JsonDeserializer;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Slf4j
@Service

public class LikeConsumer {
    private final LikeCommentService likeCommentService;

    @KafkaListener(
            topics = LikeStatusEvent.Topic,
            properties = {JsonDeserializer.VALUE_DEFAULT_TYPE + ":com.gorae.gorae_board.kafka.consumer.like.dto.LikeStatusEvent"})

    public void handleLikeStatusEvent(LikeStatusEvent event, Acknowledgment ack) {
        log.info("Received LikeStatusEvent: {}", event);
        if ("좋아요".equals(event.getAction())) {
            likeCommentService.processCommentLike(event);
            ack.acknowledge();
        }
        if ("싫어요".equals(event.getAction())) {
            //likeCommentService.processCommentLikeCancel(event);
            ack.acknowledge();
        }
    }

}
