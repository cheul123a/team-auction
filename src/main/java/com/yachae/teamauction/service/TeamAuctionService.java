package com.yachae.teamauction.service;

import com.yachae.teamauction.domain.chat.ChatLogRepository;
import com.yachae.teamauction.domain.most.PlayerMost;
import com.yachae.teamauction.domain.most.PlayerMostRepository;
import com.yachae.teamauction.domain.player.Player;
import com.yachae.teamauction.domain.player.PlayerRepository;
import com.yachae.teamauction.dto.ChatDto;
import com.yachae.teamauction.dto.RegisterPlayerDto;
import com.yachae.teamauction.global.utils.api.SuccessResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.messaging.converter.SimpleMessageConverter;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by MinKyu Kim
 * Created on 2021-12-27.
 **/

@Service
@RequiredArgsConstructor
public class TeamAuctionService {

    private final ChatLogRepository chatLogRepository;
    private final PlayerRepository playerRepository;
    private final PlayerMostRepository playerMostRepository;
    private final SimpMessagingTemplate messagingTemplate;

    private boolean isAuctionStarted = false;
    private int currentHighestBid = 0;
    private String currentBidder = "";

    public void processChat(ChatDto dto) {
        if (isAuctionStarted && dto.isBid()) {
            int bidBalance = Integer.valueOf(dto.getMessage().substring(3).trim());
            if(bidBalance > currentHighestBid) {
                currentHighestBid = bidBalance;
                currentBidder = dto.getUserName();

                sendChat(ChatDto.builder()
                        .userName("관리자")
                        .message(String.format("%s님이 %d원을 입찰하셨습니다.", currentBidder, currentHighestBid))
                        .messageTime(LocalDateTime.now())
                        .build());

            }
        }

        sendChat(dto);
        saveChat(dto);
    }

    public void openAuction() {
        isAuctionStarted = true;
    }

    public void closeAuction() {
//        낙찰한 팀장의 팀에 소속되고 팀장 포인트 감소
        isAuctionStarted = false;
        currentHighestBid = 0;
        currentBidder = "";
    }


    public SuccessResponse<?> addPlayer(List<RegisterPlayerDto> dto) {
        List<Player> playerEntity = new ArrayList<>();
        dto.forEach(player -> {
           playerEntity.add(player.toEntity());
        });

        playerRepository.saveAll(playerEntity);
        return new SuccessResponse<>();
    }

    public SuccessResponse<?> getPlayer() {
        return new SuccessResponse<>(
                playerRepository.findAll()
        );
    }

    private void saveChat(ChatDto dto) {
        chatLogRepository.save(dto.toEntity());
    }

    private void sendChat(ChatDto dto) {
        messagingTemplate.convertAndSend("/topic/chatListener", dto);
    }
}
