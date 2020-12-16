package com.gaming.pollservice.model.dto;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ChoiceDto {
    private Long id;
    private String text;
}
