package com.gaming.pollservice.model.converter;

import com.gaming.pollservice.domain.Vote;
import com.gaming.pollservice.model.dto.VoteDto;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring",uses = {PollConverter.class, ChoiceConverter.class })
public interface VoteConverter extends BaseConverter<Vote, VoteDto> {
}