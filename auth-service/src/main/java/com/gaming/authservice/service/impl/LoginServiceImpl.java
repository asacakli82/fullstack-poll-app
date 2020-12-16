package com.gaming.authservice.service.impl;

import com.gaming.authservice.service.UserAuthenticator;
import com.gaming.authservice.exception.AuthException;
import com.gaming.authservice.model.PollUser;
import com.gaming.authservice.model.request.LoginRequest;
import com.gaming.authservice.model.response.LoginResponse;
import com.gaming.authservice.service.LoginService;
import com.gaming.authservice.util.JwtUtil;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
@Slf4j
public class LoginServiceImpl implements LoginService {

    private final UserAuthenticator authenticator;
    private final JwtUtil jwtUtil;

    public LoginResponse login(LoginRequest request) {
        var builder = LoginResponse.builder();
        try {
            PollUser user = authenticator.authenticate(request.getUsernameOrEmail(), request.getPassword());
            String token = jwtUtil.generateToken(user);
            builder.success(true).accessToken(token).user(user);
        } catch (AuthException e) {
            builder.success(false);
            throw new RuntimeException("Lütfen bilgilerinizi kontrol edin.");
        }
        return builder.build();
    }

}
