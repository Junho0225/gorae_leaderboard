package com.gorae.gorae_board.controller;

import com.gorae.gorae_board.service.UserService;
import com.gorae.gorae_board.domain.dto.UserDto;
import com.gorae.gorae_board.domain.entity.User;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/user-badges")

public class UserController {
    private final UserService userService;

    // 뱃지 등록 API
    @PostMapping
    public ResponseEntity<String> createUserBadge(@RequestBody UserDto dto) {
        userService.saveUserBadge(dto);
        return ResponseEntity.ok("뱃지 저장 완료");
    }

    // 전체 조회 API
    @GetMapping
    public ResponseEntity<List<User>> getAllUserBadges() {
        return ResponseEntity.ok(userService.getAllUserBadges());
    }

    // 특정 사용자 뱃지 조회 API
    @GetMapping("/{userId}")
    public ResponseEntity<List<User>> getUserBadges(@PathVariable Long userId) {
        return ResponseEntity.ok(userService.getUserBadgesByUserId(userId));
    }

}

