//package com.yachae.teamauction.global.error;
//
//import com.blockware.coinswaprest.global.utils.api.ErrorResponse;
//import com.fasterxml.jackson.databind.ObjectMapper;
//import lombok.RequiredArgsConstructor;
//import org.springframework.http.HttpStatus;
//import org.springframework.security.web.AuthenticationEntryPoint;
//
//import javax.servlet.ServletException;
//import javax.servlet.http.HttpServletRequest;
//import javax.servlet.http.HttpServletResponse;
//import java.io.IOException;
//import java.io.PrintWriter;
//
//@RequiredArgsConstructor
//public class AuthEntryPoint implements AuthenticationEntryPoint {
//    private final HttpStatus httpStatus;
//
//    @Override
//    public void commence(HttpServletRequest request, HttpServletResponse response, org.springframework.security.core.AuthenticationException authException) throws IOException, ServletException {
//        response.setStatus(httpStatus.value());
//        response.setContentType("application/json;charset=UTF-8");
//
//        PrintWriter writer = response.getWriter();
//        writer.print(new ObjectMapper().writeValueAsString(getUnAuthorizedBody()));
//    }
//
//    private ErrorResponse getUnAuthorizedBody() {
//
//        return new ErrorResponse("1000", "unauthorized");
//    }
//}
