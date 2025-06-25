package com.gorae.gorae_board.service;

import com.gorae.gorae_board.domain.dto.UserDto;
import com.gorae.gorae_board.domain.entity.User;
import com.gorae.gorae_board.domain.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor

public class UserService {
    private final UserRepository userRepository;

    // 뱃지 등록
    public void saveUserBadge(UserDto dto) {
        User user = new User();
        user.setUserId(dto.getUserId());
        user.setBadgeStatus(dto.getBadgeStatus());
        user.setAwardedAt(dto.getAwardedAt());
        user.setCommentCount(dto.getCommentCount());
        user.setLikeCount(dto.getLikeCount());
        user.setSelectedCount(dto.getSelectedCount());

        userRepository.save(user);
    }

    // 전체 조회
    public List<User> getAllUserBadges() {
        return userRepository.findAll();
    }

    // 사용자별 조회
    public List<User> getUserBadgesByUserId(Long userId) {
        return userRepository.findByUserId(userId);
    }
}
