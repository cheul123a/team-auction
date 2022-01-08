package com.yachae.teamauction.controller;

import com.yachae.teamauction.dto.RegisterPlayerDto;
import com.yachae.teamauction.global.utils.api.SuccessResponse;
import com.yachae.teamauction.service.TeamAuctionService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

/**
 * Created by MinKyu Kim
 * Created on 2021-12-27.
 **/

@RestController
@RequiredArgsConstructor
@RequestMapping("/api")
@CrossOrigin("*")
public class TeamAuctionController {

    private final TeamAuctionService teamAuctionService;

    @PostMapping("player")
    public ResponseEntity<?> registerPlayer(@RequestBody @Valid List<RegisterPlayerDto> dto){
        return ResponseEntity.ok(teamAuctionService.addPlayer(dto));
    }

    @GetMapping("player")
    public ResponseEntity<?> getPlayers(){
        return ResponseEntity.ok(teamAuctionService.getPlayer());
    }

    @GetMapping("/test")
    public String test() {
//        teamAuctionService.test();
        return "test";
    }

}
