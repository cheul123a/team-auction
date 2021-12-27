package com.yachae.teamauction.controller;

import com.yachae.teamauction.dto.ChatDto;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by MinKyu Kim
 * Created on 2021-12-27.
 **/

@RestController
public class SocketController {

    @MessageMapping("/chat")
    @SendTo("/topic/chatListener")
    public ChatDto hello(ChatDto dto) {
        return dto;
    }
}
