package com.gaming.authservice.model.response;

import com.gaming.authservice.model.PollUser;
import com.gaming.authservice.model.dto.UserDto;
import lombok.Builder;
import lombok.Value;

@Value
@Builder
public class LoginResponse {
    Boolean success;
    String accessToken;
    PollUser user;
}
