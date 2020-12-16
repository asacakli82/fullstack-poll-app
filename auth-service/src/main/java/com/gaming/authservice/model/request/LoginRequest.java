package com.gaming.authservice.model.request;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class LoginRequest {
    private String usernameOrEmail;
    private String password;
}
