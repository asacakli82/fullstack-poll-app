package com.gaming.pollservice.model.response;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ChoiceResponse {

    private Long id;
    private String text;
    private Long voteCount;

}
