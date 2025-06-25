package com.gorae.gorae_board.domain.dto;

import java.time.LocalDateTime;
import lombok.Getter;
import lombok.Setter;



@Getter
@Setter


public class UserDto {
    private Long userId;
    private Long badgeStatus;
    private LocalDateTime awardedAt;
    private Long commentCount;
    private Long likeCount;
    private Long selectedCount;
}
