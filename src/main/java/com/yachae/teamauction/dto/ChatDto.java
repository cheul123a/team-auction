package com.yachae.teamauction.dto;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

/**
 * Created by MinKyu Kim
 * Created on 2021-12-27.
 **/

@Getter
@Setter
public class ChatDto {
    private String userName;
    private String message;
    private LocalDateTime messageTime;

}
