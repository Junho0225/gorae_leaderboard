package com.gorae.gorae_board.domain.repository;

import com.gorae.gorae_board.domain.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserRepository extends JpaRepository<User, String> {
    List<User> findByUserId(Long userId);
}
