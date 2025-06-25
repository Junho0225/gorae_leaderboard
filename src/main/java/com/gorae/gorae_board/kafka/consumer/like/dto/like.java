package com.gorae.gorae_board.kafka.consumer.like.dto;


import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter

public class like {
    private String commentLikeUserId;
    private String commentId;
    private String action;
}
