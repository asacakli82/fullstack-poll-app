package com.gaming.pollservice.model.response;

import com.gaming.pollservice.model.dto.PollDto;
import com.gaming.pollservice.model.dto.PollDuration;
import com.gaming.pollservice.model.request.ChoiceRequest;
import lombok.*;

import javax.validation.Valid;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class PollResponse {

    private Boolean success;
    private PollDto pollDto;

}
