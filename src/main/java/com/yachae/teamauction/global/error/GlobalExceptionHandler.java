package com.yachae.teamauction.global.error;


import com.yachae.teamauction.global.utils.api.ErrorResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@Slf4j
@ControllerAdvice
public class GlobalExceptionHandler {

//    @ExceptionHandler(UserAlreadyFoundUidException.class)
//    public ResponseEntity<?> handleUserAlreadyFoundUidException(UserAlreadyFoundUidException e) {
//        log.error(e.getMessage());
//
//        return failedResponse(
//            HttpStatus.BAD_REQUEST, "4000", e.getMessage()
//        );
//    }



    private ResponseEntity<?> failedResponse(HttpStatus status, String resultCode, String message) {

        return ResponseEntity.status(status).body(new ErrorResponse(resultCode, message));
    }
}
