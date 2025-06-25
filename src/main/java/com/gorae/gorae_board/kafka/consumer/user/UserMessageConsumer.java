package com.gorae.gorae_board.kafka.consumer.user;

import com.gorae.gorae_board.kafka.consumer.user.dto.UserLeaderBoardEvent;
import com.gorae.gorae_board.kafka.consumer.user.service.UserConsumerService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.support.Acknowledgment;
import org.springframework.kafka.support.serializer.JsonDeserializer;
import org.springframework.stereotype.Service;

@Slf4j
@Service
@RequiredArgsConstructor

public class UserMessageConsumer {
    private final UserConsumerService userService;

    @KafkaListener(
            topics = UserLeaderBoardEvent.Topic,
            properties = {JsonDeserializer.VALUE_DEFAULT_TYPE + ":com.gorae.gorae_board.kafka.consumer.user.dto.UserLeaderBoardEvent"})

    public void handleUserLeaderBoardEvent(UserLeaderBoardEvent event, Acknowledgment ack) {
        log.info("Received UserLeaderBoardEvent: {}", event);
        userService.processLeaderBoardEvent(event);
        ack.acknowledge();
    }
}

