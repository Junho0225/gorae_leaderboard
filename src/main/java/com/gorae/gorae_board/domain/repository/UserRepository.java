package com.gorae.gorae_board.domain.repository;

import com.gorae.gorae_board.domain.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User, String> {
    Optional<User> findByUserId(String userId);

    // 좋아요 수 내림차순
    List<User> findTop10ByOrderByLikeCountDesc();

    // 채택 수 내림차순
    List<User> findTop10ByOrderBySelectedCountDesc();

    // 전체 유저 조회
    List<User> findAll();

}
