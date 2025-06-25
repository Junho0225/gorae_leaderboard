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
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id") // 기본키 컬럼
    private Long id;

    @Column(name="user_name")
    private String userName;

    @Column(name = "user_id", nullable = false)
    private String userId; // UserEntity와 연관 (User 테이블의 PK)

    @Column(name="profile_img_url")
    private String profileImgUrl;

    @Column(name = "userBadge", nullable = false)
    private String userBadge = "1";; // Badge Table의 FK (획득한 뱃지 종류) (1,2,3,4,5)

    @Column(name = "likeBadge", nullable = false) //(획득한 뱃지) (1,2,3,4,5)
    private String likeBadge = "1";

    @Column(name = "awarded_at")
    private LocalDateTime awardedAt; // 뱃지 획득 일시

    @Column(name = "comment_count")
    private String commentCount; // 댓글 수

    @Column(name = "like_count")
    private String likeCount; // 좋아요 수

    @Column(name = "selected_count")
    private String selectedCount; // 채택 수
}
