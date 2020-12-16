package com.gaming.authservice.util;



import com.gaming.authservice.domain.Role;
import com.gaming.authservice.domain.User;
import com.gaming.authservice.model.PollUser;

import java.util.Set;
import java.util.stream.Collectors;

public class AccountMapper {

    public static PollUser getUser(User user,Set<Role> roles ) {

        return PollUser.builder().name(user.getName())
                .username(user.getUsername()).id(user.getId())
                    .authorities(roles.stream().map(role->role.getName().name())
                                .collect(Collectors.toSet()))
                                    .build();
    }


}
