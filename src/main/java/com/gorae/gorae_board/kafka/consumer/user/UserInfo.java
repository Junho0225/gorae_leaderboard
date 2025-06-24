package com.gorae.gorae_post.kafka.consumer.user;

import lombok.*;

import java.time.LocalDateTime;

@Getter
@Setter
@Builder

public class UserInfo {
    public static final String Topic = "user";

    private String action;

    private String userId;
    private String userName;
    private String profileImgUrl;
    private String userBadge;

    private LocalDateTime eventTime;
}
