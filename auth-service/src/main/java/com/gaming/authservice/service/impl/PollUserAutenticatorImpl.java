package com.gaming.authservice.service.impl;

import com.gaming.authservice.domain.Role;
import com.gaming.authservice.domain.User;
import com.gaming.authservice.exception.AccountNotActiveException;
import com.gaming.authservice.exception.AccountNotFoundException;
import com.gaming.authservice.exception.BadCredentialsException;
import com.gaming.authservice.repository.UserRepository;
import com.gaming.authservice.service.UserAuthenticator;
import com.gaming.authservice.model.PollUser;
import com.gaming.authservice.util.AccountMapper;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Objects;
import java.util.Optional;
import java.util.Set;

@Service
@RequiredArgsConstructor
@Slf4j
public class PollUserAutenticatorImpl implements UserAuthenticator {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    @Override
    public PollUser authenticate(String userNameOrEmail, String password) {

        Optional<User> user = userRepository.findByUsernameOrEmail(userNameOrEmail,userNameOrEmail);

        if (user.isPresent()) {
            var account = user.get();

            if (Objects.equals(account.getIsActive(), true)) {
                if (passwordEncoder.matches(password,account.getPassword())) {
                    log.info("Authentication successful. [userNameOrEmail: {}]", userNameOrEmail);
                    Set<Role> roles = account.getRoles();
                    return AccountMapper.getUser(account,roles);
                } else {
                    log.info("Password mismatched. [userNameOrEmail: {}]", userNameOrEmail);
                    throw new BadCredentialsException();
                }
            } else {
                log.info("Account is not active. [userNameOrEmail: {}]", userNameOrEmail);
                throw new AccountNotActiveException();
            }
        } else {
            log.info("Account not found. [userNameOrEmail: {}]", userNameOrEmail);
            throw new AccountNotFoundException();
        }


    }
}
