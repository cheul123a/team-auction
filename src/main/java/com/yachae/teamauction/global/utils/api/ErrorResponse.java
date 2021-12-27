package com.yachae.teamauction.global.utils.api;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

/**
 * Created by MinKyu Kim
 * Created on 2021-11-15.
 **/

@Getter
@Setter
@AllArgsConstructor
public class ErrorResponse {
    private String resultCode;
    private String message;
}
