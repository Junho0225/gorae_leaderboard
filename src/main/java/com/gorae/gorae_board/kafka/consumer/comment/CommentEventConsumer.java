package com.gorae.gorae_board.kafka.consumer.comment;

import com.gorae.gorae_board.kafka.consumer.comment.dto.AdoptStatusCommentEvent;
import com.gorae.gorae_board.kafka.consumer.comment.dto.CommentEvent;
import com.gorae.gorae_board.kafka.consumer.comment.service.CommentEventConsumerService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.support.Acknowledgment;
import org.springframework.kafka.support.serializer.JsonDeserializer;
import org.springframework.stereotype.Service;

@Slf4j
@Service
@RequiredArgsConstructor

public class CommentEventConsumer {
    private final CommentEventConsumerService commentEventConsumerService;


    @KafkaListener(
            topics = CommentEvent.TOPIC,
            properties = {JsonDeserializer.VALUE_DEFAULT_TYPE + ":com.gorae.gorae_board.kafka.consumer.comment.dto.CommentEvent"})
    public void handleAdoptStatusCommentEvent(CommentEvent event, Acknowledgment ack) {
        log.info("Received CommentEvent: {}", event);
        commentEventConsumerService.processCommentStatusEvent(event);
        ack.acknowledge();
    }
}
