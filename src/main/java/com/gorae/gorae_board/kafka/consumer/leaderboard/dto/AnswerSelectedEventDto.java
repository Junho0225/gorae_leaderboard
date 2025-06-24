package com.gorae.gorae_post.kafka.consumer.leaderboard.dto;

public class AnswerSelectedEventDto {
    public static final String TOPIC = "answer-selected-info";

    //채택받은 정보 수신
    private String action;

    private String userId;

    private String userName;

}
