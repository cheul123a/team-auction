package com.yachae.teamauction.service;

import com.yachae.teamauction.domain.ChatLogRepository;
import com.yachae.teamauction.dto.ChatDto;
import lombok.RequiredArgsConstructor;
import org.hibernate.annotations.DynamicInsert;
import org.springframework.stereotype.Service;

/**
 * Created by MinKyu Kim
 * Created on 2021-12-27.
 **/

@Service
@RequiredArgsConstructor
public class TeamAuctionService {

    private final ChatLogRepository chatLogRepository;

    private boolean isAuctionStarted = false;


    public void saveChat(ChatDto dto) {
        chatLogRepository.save(dto.toEntity());
    }

    public void openAuction() {
        isAuctionStarted = true;
    }

    public void closeAuction() {
        isAuctionStarted = false;
    }
}
