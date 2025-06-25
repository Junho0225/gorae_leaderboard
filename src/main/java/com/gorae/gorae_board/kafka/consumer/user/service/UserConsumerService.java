package com.gorae.gorae_board.kafka.consumer.user.service;



import com.gorae.gorae_board.domain.entity.User;
import com.gorae.gorae_board.domain.repository.UserRepository;
import com.gorae.gorae_board.kafka.consumer.user.dto.UserLeaderBoardEvent;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Slf4j
@Service
@RequiredArgsConstructor

public class UserConsumerService {
    private final UserRepository userRepository;

    @Transactional
    public void processLeaderBoardEvent(UserLeaderBoardEvent event) {

        if ("register".equals(event.getAction())) {
            User user = new User();
            user.setUserId(event.getUserId());
            user.setUserName(event.getUserName());
            user.setProfileImgUrl(event.getProfileImgUrl());
            userRepository.save(user);
        }
    }
}