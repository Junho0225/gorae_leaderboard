package com.gorae.gorae_board.kafka.consumer.comment.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter

public class CommentEvent {
    public static final String TOPIC = "comment-produce";


    private String commentUserId;//채택된 답변의 유저 Id
}
