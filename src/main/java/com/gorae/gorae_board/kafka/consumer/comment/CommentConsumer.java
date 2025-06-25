package com.gorae.gorae_board.kafka.consumer.comment;


import com.gorae.gorae_board.kafka.consumer.comment.dto.AdoptStatusCommentEvent;
import com.gorae.gorae_board.kafka.consumer.comment.service.CommentConsumerService;
import com.gorae.gorae_board.kafka.consumer.user.dto.UserLeaderBoardEvent;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.support.Acknowledgment;
import org.springframework.kafka.support.serializer.JsonDeserializer;
import org.springframework.stereotype.Service;

@Slf4j
@Service
@RequiredArgsConstructor
public class CommentConsumer {
    private final CommentConsumerService commentConsumerService;

    @KafkaListener(
            topics = AdoptStatusCommentEvent.TOPIC,
            properties = {JsonDeserializer.VALUE_DEFAULT_TYPE + ":com.gorae.gorae_board.kafka.consumer.comment.dto.AdoptStatusCommentEvent"})
    public void handleAdoptStatusCommentEvent(AdoptStatusCommentEvent event, Acknowledgment ack) {
        log.info("Received AdoptStatusCommentEvent: {}", event);
        commentConsumerService.processAdoptStatusCommentEvent(event);
        ack.acknowledge();
    }
}
