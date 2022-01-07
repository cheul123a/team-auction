package com.yachae.teamauction.dto;

import com.yachae.teamauction.domain.chat.ChatLog;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

/**
 * Created by MinKyu Kim
 * Created on 2021-12-27.
 **/

@Getter
@Setter
@Builder
public class ChatDto {
    private String userName;
    private String message;
    private LocalDateTime messageTime;

    public boolean isBid() {
        return message.startsWith("!입찰");
    }

    public ChatLog toEntity() {
        return ChatLog.builder()
                .userName(userName)
                .message(message)
                .messageTime(messageTime)
                .build();
    }
}
