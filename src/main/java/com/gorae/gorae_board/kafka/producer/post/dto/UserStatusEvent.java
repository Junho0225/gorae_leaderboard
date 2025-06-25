package com.gorae.gorae_board.kafka.producer.post.dto;

import com.gorae.gorae_board.domain.entity.User;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UserStatusEvent {
    // 질문 상세보기, 답변 에서 보여줄 뱃지
    public static final String TOPIC = "user-status";

    private String userId;

    private String userBadge;

    private String likeBadge;

    public static UserStatusEvent fromEntity(User user){
        UserStatusEvent event = new UserStatusEvent();

        event.userId = user.getUserId();
        event.userBadge = user.getUserBadge().toString();
        event.likeBadge = user.getLikeBadge().toString();

        return event;
    }
}