package com.gaming.pollservice.auth;


import org.springframework.security.core.userdetails.UserDetails;

public interface User extends  UserDetails {

    Long  getId();
    String getName();
    String getUsername();


}
