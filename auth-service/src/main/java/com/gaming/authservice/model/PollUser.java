package com.gaming.authservice.model;


import com.fasterxml.jackson.annotation.JsonIgnore;
import com.gaming.authservice.domain.enums.RolesEnum;
import io.jsonwebtoken.Claims;
import lombok.*;
import lombok.experimental.Accessors;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.util.StringUtils;

import java.util.*;
import java.util.stream.Collectors;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class PollUser {

    private Long id;
    private String name;
    private String username;
    @JsonIgnore
    private String email;
    @JsonIgnore
    private String password;
    @JsonIgnore
    private Set<String> authorities;
    private String type = "anonymous";


    public String getType() {

        if(Optional.ofNullable(authorities).isPresent()){
            if(authorities.contains(RolesEnum.ROLE_ADMIN.name())){
                type = "admin";
            }else if(authorities.contains(RolesEnum.ROLE_USER.name())){
                type = "user";
            }
        }

       return type;
    }


}
