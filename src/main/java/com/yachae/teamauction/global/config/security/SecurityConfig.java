//package com.yachae.teamauction.global.config.security;
//
//import com.blockware.coinswaprest.global.error.AuthEntryPoint;
//import com.blockware.coinswaprest.service.security.JwtAuthenticationFilter;
//import com.blockware.coinswaprest.service.security.JwtTokenProvider;
//import lombok.RequiredArgsConstructor;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.http.HttpStatus;
//import org.springframework.security.authentication.AuthenticationManager;
//import org.springframework.security.config.annotation.web.builders.HttpSecurity;
//import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
//import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
//import org.springframework.security.config.http.SessionCreationPolicy;
//import org.springframework.security.crypto.factory.PasswordEncoderFactories;
//import org.springframework.security.crypto.password.PasswordEncoder;
//import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
//import org.springframework.web.cors.CorsConfiguration;
//import org.springframework.web.cors.CorsConfigurationSource;
//import org.springframework.web.cors.UrlBasedCorsConfigurationSource;
//
//import java.util.HashMap;
//import java.util.Map;
//
//@RequiredArgsConstructor
//@Configuration
//@EnableWebSecurity
//public class SecurityConfig extends WebSecurityConfigurerAdapter {
//
//    private final JwtTokenProvider jwtTokenProvider;
//    // 패스워드 암호화 bean 등록
//    @Bean
//    public PasswordEncoder passwordEncoder() {
//        return  PasswordEncoderFactories.createDelegatingPasswordEncoder();
//    }
//
//    @Bean
//    @Override
//    public AuthenticationManager authenticationManagerBean() throws Exception {
//        return super.authenticationManagerBean();
//    }
//
//    @Override
//    protected void configure(HttpSecurity http) throws Exception {
//        Map<String, String> responseBody = new HashMap<>();
//        responseBody.put("resultCode", "1000");
//        responseBody.put("message", "unauthorized");
//
//        http.httpBasic().disable() // 기본설정 해제
//                .csrf().disable() //csrf 보안 토큰 disable
//                .cors().configurationSource(corsConfigurationSource())
//                .and()
//                .sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS) // 토큰 기반 인증이므로 세션 관리를 하지 않음
//                .and()
//                .exceptionHandling()
//                .authenticationEntryPoint(new AuthEntryPoint(HttpStatus.UNAUTHORIZED))
//                .and()
//                .authorizeRequests() // 요청에 대한 권한 체크
//                .antMatchers("/api/user/sign-up",  "/api/admin/update-uuid", "/api/admin/not-registered-phone", "/api/user/sign-in", "/api/user/send-reset-password-mail", "/api/user/email-verification/**", "/api/user/reset-password/**").permitAll()
//                .antMatchers("/api/user/**").hasAnyRole("USER", "ADMIN", "MQL_ADMIN")
//                .antMatchers("/api/swap/**").hasAnyRole("USER", "ADMIN", "MQL_ADMIN")
//                .antMatchers("/api/admin/**").hasAnyRole("ADMIN", "MQL_ADMIN")
//                .anyRequest().permitAll()
//                .and()
//                .addFilterBefore(new JwtAuthenticationFilter(jwtTokenProvider),
//                        UsernamePasswordAuthenticationFilter.class);
//                // JwtAuthenticationFilter를 UsernamePasswordAuthenticationFilter 전에 넣는다
//    }
//
//    @Bean
//    public CorsConfigurationSource corsConfigurationSource() {
//        CorsConfiguration configuration = new CorsConfiguration();
//
//        configuration.addAllowedOrigin("*");
//        configuration.addAllowedHeader("*");
//        configuration.addAllowedMethod("*");
//
//        UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
//        source.registerCorsConfiguration("/**", configuration);
//
//        return source;
//    }
//}
