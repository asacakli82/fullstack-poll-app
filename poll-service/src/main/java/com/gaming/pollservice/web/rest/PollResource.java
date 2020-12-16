package com.gaming.pollservice.web.rest;

import com.gaming.pollservice.auth.UserPrincipal;
import com.gaming.pollservice.model.request.PollRequest;
import com.gaming.pollservice.model.response.PagedResponse;
import com.gaming.pollservice.model.response.PollResponse;
import com.gaming.pollservice.model.response.PollSummaryResponse;
import com.gaming.pollservice.service.PollService;
import com.gaming.pollservice.util.ModalMapper;
import io.swagger.annotations.Api;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/api/polls")
@Api(value="Poll API")
@RequiredArgsConstructor
public class PollResource {

    private final PollService pollService;

    @GetMapping
    @PreAuthorize("hasRole('ADMIN')")
    public ResponseEntity<PagedResponse<PollSummaryResponse>> getPolls(@RequestParam(value = "page", defaultValue = "0") int page,
                                                                       @RequestParam(value = "size", defaultValue = "10") int size)
    {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        UserPrincipal principal = (UserPrincipal) auth.getPrincipal();

        return ResponseEntity.ok().body(pollService.getPolls(ModalMapper.getPollUser(principal), page, size));
    }

    @GetMapping("/proposal")
    @PreAuthorize("hasRole('ADMIN')")
    public ResponseEntity<PagedResponse<PollSummaryResponse>> getProposalPolls(@RequestParam(value = "page", defaultValue = "0") int page,
                                                                       @RequestParam(value = "size", defaultValue = "10") int size)
    {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        UserPrincipal principal = (UserPrincipal) auth.getPrincipal();

        return ResponseEntity.ok().body(pollService.getProposalPolls(ModalMapper.getPollUser(principal), page, size));
    }

    @GetMapping("/enduser")
    @PreAuthorize("hasRole('USER')")
    public ResponseEntity<PagedResponse<PollSummaryResponse>> getEndUserPolls(@RequestParam(value = "page", defaultValue = "0") int page,
                                                                               @RequestParam(value = "size", defaultValue = "10") int size)
    {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        UserPrincipal principal = (UserPrincipal) auth.getPrincipal();

        return ResponseEntity.ok().body(pollService.getPollsForEndUser(ModalMapper.getPollUser(principal), page, size));
    }


    @PostMapping("/create")
    @PreAuthorize("hasRole('ADMIN')")
    public ResponseEntity<PollResponse> createPoll(@Valid @RequestBody PollRequest pollRequest) {

        return  ResponseEntity.ok().body(pollService.createPoll(pollRequest));
    }

    @PostMapping("/propose")
    @PreAuthorize("hasRole('USER')")
    public ResponseEntity<PollResponse> proposePoll(@Valid @RequestBody PollRequest pollRequest) {

        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        UserPrincipal principal = (UserPrincipal) auth.getPrincipal();

        return  ResponseEntity.ok().body(pollService.proposePoll(ModalMapper.getPollUser(principal),pollRequest));
    }

    @GetMapping("/{pollId}")
    @PreAuthorize("hasRole('ADMIN')")
    public PollSummaryResponse getPollById(@PathVariable Long pollId) {

        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        UserPrincipal principal = (UserPrincipal) auth.getPrincipal();

        return pollService.getPollById(pollId, ModalMapper.getPollUser(principal));
    }

    @PreAuthorize("hasRole('ADMIN')")
    @PostMapping("/{pollId}/delete")
    public ResponseEntity deletePoll(@PathVariable Long pollId) {

        pollService.deletePoll(pollId);
        return ResponseEntity.ok().build();
    }

    @PreAuthorize("hasRole('ADMIN')")
    @PostMapping("/{pollId}/doPassive")
    public ResponseEntity doPassive(@PathVariable Long pollId) {

        pollService.doPassivePoll(pollId);
        return ResponseEntity.ok().build();
    }

    @PreAuthorize("hasRole('ADMIN')")
    @PostMapping("/{pollId}/confirm")
    public ResponseEntity doConfirm(@PathVariable Long pollId) {

        pollService.confirmPoll(pollId);
        return ResponseEntity.ok().build();
    }

    @PreAuthorize("hasRole('ADMIN')")
    @PostMapping("/{pollId}/{choiceId}/voted")
    public ResponseEntity voted(@PathVariable Long pollId,@PathVariable Long choiceId) {

        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        UserPrincipal principal = (UserPrincipal) auth.getPrincipal();

        pollService.voted(pollId,choiceId,ModalMapper.getPollUser(principal));
        return ResponseEntity.ok().build();
    }


}
