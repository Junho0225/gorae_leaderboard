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
    @Column(name = "id") // 뱃지 고유 번호
    private Long id;

    @Column(name = "user_id", nullable = false)
    private Long userId; // UserEntity와 연관 (User 테이블의 PK)

    @Column(name = "badge_status", nullable = false)
    private Long badgeStatus; // Badge Table의 FK (획득한 뱃지 종류)

    @Column(name = "awarded_at")
    private LocalDateTime awardedAt; // 뱃지 획득 일시

    @Column(name = "comment_count")
    private Long commentCount; // 댓글 수

    @Column(name = "like_count")
    private Long likeCount; // 좋아요 수

    @Column(name = "selected_count")
    private Long selectedCount; // 채택 수
}
