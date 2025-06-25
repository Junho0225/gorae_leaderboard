package com.gorae.gorae_board.domain.dto;

import java.time.LocalDateTime;
import lombok.Getter;
import lombok.Setter;



@Getter
@Setter


public class UserDto {
    private String userId;
    private String userName;
    private String userBadge;      // (1~5)
    private String likeBadge;      // (1~5)
    private String profileImgUrl;
    private Long commentCount;
    private Long likeCount;
    private Long selectedCount;
    private Double selectedRate; // 채택률, 실시간 계산 (선택수/댓글수*100)
    private LocalDateTime awardedAt;
}
