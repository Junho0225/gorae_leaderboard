package com.gorae.gorae_board.domain.dto;

import java.time.LocalDateTime;
import lombok.Getter;
import lombok.Setter;



@Getter
@Setter

public class LeaderBoardDto {
    private Long userId;
    private String username;
    private Long recommendPoint;
    private Long questionCount;
}
