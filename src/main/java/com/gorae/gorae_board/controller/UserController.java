package com.gorae.gorae_board.controller;

import com.gorae.gorae_board.common.GatewayRequestHeaderUtils;
import com.gorae.gorae_board.service.UserService;
import com.gorae.gorae_board.domain.dto.UserDto;
import com.gorae.gorae_board.domain.entity.User;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/leaderboard/v1")
public class UserController {
    private final UserService userService;

    //정보 조회
    @GetMapping("/detail")
    public ResponseEntity<UserDto> getUserInfo() {
        String userId = GatewayRequestHeaderUtils.getUserId();
        return ResponseEntity.ok(userService.getUserInfo(userId));
    }

    //좋아요 순위
    @GetMapping("auth/likes/all")
    public ResponseEntity<List<UserDto>> getAllUsersByLikes() {
        return ResponseEntity.ok(userService.getAllUsersByLikes());
    }

    //채택 순위
    @GetMapping("auth/selected/all")
    public ResponseEntity<List<UserDto>> getAllUsersBySelected() {
        return ResponseEntity.ok(userService.getAllUsersBySelected());
    }

    //채택률 순위
    @GetMapping("auth/selectedrate/all")
    public ResponseEntity<List<UserDto>> getAllUsersBySelectedRate() {
        return ResponseEntity.ok(userService.getAllUsersBySelectedRate());
    }

}

