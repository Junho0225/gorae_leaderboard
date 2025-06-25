package com.gorae.gorae_board.kafka.consumer.like.dto;


import lombok.Getter;
import lombok.Setter;

@Getter
@Setter

public class LikeStatusEvent {
    public static final String Topic = "like-comment-status";

    private String commentLikeUserId;
    private String commentId;
    private String action;
}
