package com.gaming.pollservice.model.converter;

import com.gaming.pollservice.domain.Choice;
import com.gaming.pollservice.domain.Poll;
import com.gaming.pollservice.model.dto.ChoiceDto;
import com.gaming.pollservice.model.dto.PollDto;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface ChoiceConverter extends BaseConverter<Choice, ChoiceDto> {
}