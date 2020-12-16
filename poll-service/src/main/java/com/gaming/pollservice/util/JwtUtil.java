package com.gaming.pollservice.util;


import com.gaming.pollservice.auth.UserPrincipal;
import io.jsonwebtoken.*;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import javax.servlet.http.HttpServletRequest;
import java.util.Date;
import java.util.Optional;
import java.util.function.Function;

@Slf4j
public class JwtUtil {

    private static final String SECRET_KEY = "gaming";
    public static final String CLAIM_DELIMETER = "##";


    public static String getJwtFromRequest(HttpServletRequest request) {
        var header = Optional.ofNullable(( request).getHeader("Authorization"));
        return header.isPresent() ? header
                .filter(auth -> auth.startsWith("Bearer "))
                .map(auth -> auth.substring(7))
                .orElse(null) : null ;
    }

    public static UserPrincipal getUserPrincipalFromJWT(String token) {
        Claims claims = Jwts.parser()
                .setSigningKey(SECRET_KEY)
                .parseClaimsJws(token)
                .getBody();

        return new UserPrincipal(claims);
    }

    public static boolean validateToken(String authToken) {
        try {
            Jwts.parser().setSigningKey(SECRET_KEY).parseClaimsJws(authToken);
            return true;
        } catch (SignatureException ex) {
            log.error("Invalid JWT signature");
        } catch (MalformedJwtException ex) {
            log.error("Invalid JWT token");
        } catch (ExpiredJwtException ex) {
            log.error("Expired JWT token");
        } catch (UnsupportedJwtException ex) {
            log.error("Unsupported JWT token");
        } catch (IllegalArgumentException ex) {
            log.error("JWT claims string is empty.");
        }
        return false;
    }


}