package com.gorae.gorae_board.service;

import com.gorae.gorae_board.domain.dto.UserDto;
import com.gorae.gorae_board.domain.entity.User;
import com.gorae.gorae_board.domain.repository.UserRepository;
import com.gorae.gorae_board.kafka.producer.KafkaMessageProducer;
import com.gorae.gorae_board.kafka.producer.post.dto.UserStatusEvent;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor

public class UserService {
    private final UserRepository userRepository;
    private final KafkaMessageProducer kafkaMessageProducer;

    //유저 상세 정보 조회
    public UserDto getUserInfo(String userId) {
        User user = userRepository.findByUserId(userId)
                .orElseThrow(() -> new RuntimeException("User not found"));

        UserStatusEvent event = UserStatusEvent.fromEntity(user);
//        kafkaMessageProducer.send(UserStatusEvent.TOPIC, event);
        return toUserDto(user);
    }

    //좋아요 개수 기준 전체 순위
    public List<UserDto> getAllUsersByLikes() {
        return userRepository.findAll().stream()
                .sorted(Comparator.comparing(User::getLikeCount, Comparator.nullsLast(Comparator.reverseOrder())))
                .map(this::toUserDto)
                .collect(Collectors.toList());
    }

    //채택 수 기준 전체 순위
    public List<UserDto> getAllUsersBySelected() {
        return userRepository.findAll().stream()
                .sorted(Comparator.comparing(User::getSelectedCount, Comparator.nullsLast(Comparator.reverseOrder())))
                .map(this::toUserDto)
                .collect(Collectors.toList());
    }

    //채택률 기준 전체 순위
    public List<UserDto> getAllUsersBySelectedRate() {
        return userRepository.findAll().stream()
                .sorted(Comparator.comparing(
                        this::calcSelectedRate,
                        Comparator.nullsLast(Comparator.reverseOrder())
                ))
                .map(this::toUserDto)
                .collect(Collectors.toList());
    }

    //User → UserDto 변환
    private UserDto toUserDto(User user) {
        UserDto dto = new UserDto();
        dto.setUserId(user.getUserId());
        dto.setUserBadge(user.getUserBadge().toString());
        dto.setLikeBadge(user.getLikeBadge().toString());
        dto.setCommentCount(user.getCommentCount());
        dto.setLikeCount(user.getLikeCount());
        dto.setSelectedCount(user.getSelectedCount());
        dto.setAwardedAt(user.getAwardedAt());

        double selectedRate = calcSelectedRate(user);
        dto.setSelectedRate(selectedRate);

        return dto;
    }

    //채택률
    private double calcSelectedRate(User user) {
        try {
            Long commentCount = user.getCommentCount();
            Long selectedCount = user.getSelectedCount();
            if (commentCount == 0) return 0.0;
            return ((double) selectedCount / commentCount) * 100;
        } catch (NumberFormatException e) {
            return 0.0;
        }
    }
}