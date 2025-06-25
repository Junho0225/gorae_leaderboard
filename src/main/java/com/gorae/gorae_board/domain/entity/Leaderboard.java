package com.gorae.gorae_board.domain.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@Entity
@Table(name = "leaderboard")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Leaderboard {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "user_id", nullable = false, unique = true)
    private Long userId;

    @Column(name = "username", nullable = false)
    private String username;

    @Column(name = "recommend_point", nullable = false)
    private Long recommendPoint = 0L;

    @Column(name = "question_count", nullable = false)
    private Long questionCount = 0L;

    @Column(name = "created_at")
    private LocalDateTime createdAt = LocalDateTime.now();
}