package com.gaming.pollservice.model.dto;

import com.gaming.pollservice.domain.BaseEntity;
import lombok.*;


@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class VoteDto extends BaseEntity {

    private PollDto poll;
    private ChoiceDto choice;


}
