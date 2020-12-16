package com.gaming.authservice.service;


import com.gaming.authservice.model.PollUser;
import org.springframework.stereotype.Service;

@Service
public interface UserAuthenticator {

    PollUser authenticate(String uid, String password);
}
