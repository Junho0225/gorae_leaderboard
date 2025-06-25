package com.gorae.gorae_board.kafka.consumer.comment.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class AdoptStatusCommentEvent {
    public static final String TOPIC = "adopt-comment-status";


    private String adoptUserId;//채택된 답변의 유저 Id
}
