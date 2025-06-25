package com.gorae.gorae_board.controller;

import com.gorae.gorae_board.domain.dto.LeaderBoardDto;
import com.gorae.gorae_board.service.LeaderboardService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/leaderboard")
public class LeaderboardController {

    private final LeaderboardService leaderboardService;

//    @GetMapping("/top")
//    public ResponseEntity<List<LeaderBoardDto>> getTopUsers(
//            @RequestParam(defaultValue = "0") int page,
//            @RequestParam(defaultValue = "5") int size) {
//        return ResponseEntity.ok(leaderboardService.getTopUsersByRecommendPoint(page, size));
//    }

    @PostMapping("/register")
    public ResponseEntity<String> registerUser(@RequestBody LeaderBoardDto dto) {
        leaderboardService.registerUser(dto.getUserId(), dto.getUsername());
        return ResponseEntity.ok("User registered in leaderboard");
    }

}