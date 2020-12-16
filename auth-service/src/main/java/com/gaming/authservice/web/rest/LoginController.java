package com.gaming.authservice.web.rest;

import com.gaming.authservice.model.request.LoginRequest;
import com.gaming.authservice.model.response.LoginResponse;
import com.gaming.authservice.model.response.TokenResponse;
import com.gaming.authservice.service.LoginService;
import com.gaming.authservice.util.JwtUtil;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@AllArgsConstructor
@RestController
@RequestMapping("/api")
public class LoginController {

    private final LoginService loginService;
    private final JwtUtil jwtUtil;

    @PostMapping("/login")
    public ResponseEntity<LoginResponse> login(@RequestBody LoginRequest request) {
        return ResponseEntity.ok().body(loginService.login(request));
    }

    @PostMapping("/token")
    public ResponseEntity<TokenResponse> tokenValidate(@RequestParam("token") String token) {

        return  ResponseEntity.ok().body(jwtUtil.validateToken(token));
    }
}
