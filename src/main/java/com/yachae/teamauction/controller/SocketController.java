package com.yachae.teamauction.controller;

import com.yachae.teamauction.dto.ChatDto;
import com.yachae.teamauction.service.TeamAuctionService;
import lombok.RequiredArgsConstructor;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDateTime;

/**
 * Created by MinKyu Kim
 * Created on 2021-12-27.
 **/

@RestController
@RequiredArgsConstructor
public class SocketController {

    private final TeamAuctionService teamAuctionService;

    @MessageMapping("/chat")
    @SendTo("/topic/chatListener")
    public ChatDto chat(ChatDto dto) {
        teamAuctionService.saveChat(dto);
        return dto;
    }

    @MessageMapping("/start-auction")
    @SendTo("/topic/chatListener")
    public ChatDto startAuction() {
//        TODO: 관리자 인지 체크
        teamAuctionService.openAuction();

        return ChatDto.builder()
                .userName("관리자")
                .message("경매가 시작되었습니다.")
                .messageTime(LocalDateTime.now())
                .build();
    }

    @MessageMapping("/end-auction")
    @SendTo("/topic/chatListener")
    public ChatDto endAuction() {
        teamAuctionService.closeAuction();

        return ChatDto.builder()
                .userName("관리자")
                .message("경매가 종료되었습니다.")
                .messageTime(LocalDateTime.now())
                .build();
    }
}
