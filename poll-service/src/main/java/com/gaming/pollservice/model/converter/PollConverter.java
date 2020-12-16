package com.gaming.pollservice.model.converter;

import com.gaming.pollservice.domain.Poll;
import com.gaming.pollservice.model.dto.PollDto;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring", uses = {ChoiceConverter.class })
public interface PollConverter extends BaseConverter<Poll, PollDto> {
}