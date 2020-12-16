package com.gaming.authservice.service;

import com.gaming.authservice.model.request.LoginRequest;
import com.gaming.authservice.model.response.LoginResponse;
import org.springframework.stereotype.Service;


@Service
public interface LoginService {

    LoginResponse login(LoginRequest request);

}
