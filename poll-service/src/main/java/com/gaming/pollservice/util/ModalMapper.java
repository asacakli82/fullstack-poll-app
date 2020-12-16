package com.gaming.pollservice.util;

import com.gaming.pollservice.auth.PollUser;
import com.gaming.pollservice.auth.UserPrincipal;
import com.gaming.pollservice.domain.Choice;
import com.gaming.pollservice.domain.Poll;
import com.gaming.pollservice.model.dto.ChoiceDto;
import com.gaming.pollservice.model.dto.PollDto;

import java.util.Objects;
import java.util.stream.Collectors;

public class ModalMapper {

    public static PollUser getPollUser(UserPrincipal user) {

        return PollUser.builder().id(user.getId())
                    .username(user.getUsername()).build();
    }

    public static PollDto getPollDto(Poll poll) {

        PollDto pollDto = PollDto.builder().id(poll.getId()) .question(poll.getQuestion())
                .username(poll.getUsername()).build();

        if(!Objects.isNull(poll.getChoices())){
            pollDto.setChoices(poll
                    .getChoices().stream().map(item->getChoiceDto(item))
                    .collect(Collectors.toList()));
        }

        return pollDto;
    }

    public static ChoiceDto getChoiceDto(Choice choice) {

        return ChoiceDto.builder()
                .id(choice.getId())
                .text(choice.getText())
                .build();
    }

}
