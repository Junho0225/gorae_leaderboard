package com.gorae.gorae_board.domain.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.time.LocalDateTime;

@Entity
@Getter
@Setter
@ToString
@Table(name = "user_badge")
public class User{

    @Id
    @Column(name = "user_id", nullable = false)
    private String userId; // UserEntity와 연관 (User 테이블의 PK)

    @Column(name="user_name")
    private String userName;

    @Column(name="profile_img_url")
    private String profileImgUrl;

    @Column(name = "userBadge", nullable = false)
    private Long userBadge = 1L;; // Badge Table의 FK (획득한 뱃지 종류) (1,2,3,4,5)

    @Column(name = "likeBadge", nullable = false) //(획득한 뱃지) (1,2,3,4,5)
    private Long likeBadge = 1L;

    @Column(name = "awarded_at")
    private LocalDateTime awardedAt; // 뱃지 획득 일시

    @Column(name = "comment_count")
    private Long commentCount = 0L; // 댓글 수

    @Column(name = "like_count")
    private Long likeCount = 0L; // 좋아요 수

    @Column(name = "selected_count")
    private Long selectedCount = 0L; // 채택 수
}
