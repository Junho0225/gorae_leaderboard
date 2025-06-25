package com.gorae.gorae_board.kafka.consumer.leaderboard.dto;

public class PostCreatedEventDto {
    public static final String TOPIC = "answer-selected-info";

    // 포스트 생성 정보 수신
    private String action;

    private String userId;

    private String userName;

    private String postid;
    
}
