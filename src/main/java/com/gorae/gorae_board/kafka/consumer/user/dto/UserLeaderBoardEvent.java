package com.gorae.gorae_board.kafka.consumer.user.dto;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
public class UserLeaderBoardEvent {
    public static final String Topic = "user-leaderboard";  // Producer와 동일

    private String action;
    private String userId;
    private String userName;
    private String profileImgUrl;
    private LocalDateTime eventTime;
}