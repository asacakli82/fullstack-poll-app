package com.gaming.authservice.model.response;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class TokenResponse {

    private Boolean success;
    private String errorMessage;

}
