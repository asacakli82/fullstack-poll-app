package com.gaming.authservice.util;

import com.gaming.authservice.model.PollUser;
import com.gaming.authservice.model.response.TokenResponse;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Component;

import java.util.Date;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Objects;
import java.util.function.Function;

@Component
@Slf4j
public class JwtUtil {

    private static final String SECRET_KEY = "gaming";
    private static final String CLAIM_DELIMETER = "##";
    private static final long   EXPIRED_TIME =  5 * 60 * 60 * 1000;

    public Date extractExpiration(String token) {
        return extractClaim(token, Claims::getExpiration);
    }

    public <T> T extractClaim(String token, Function<Claims, T> claimsResolver) {
        final Claims claims = extractAllClaims(token);
        return claimsResolver.apply(claims);
    }

    private Claims extractAllClaims(String token) {
        return Jwts.parser().setSigningKey(SECRET_KEY).parseClaimsJws(token).getBody();
    }

    private Boolean isTokenExpired(String token) {
        return extractExpiration(token).before(new Date());
    }


    public String generateToken(PollUser user) {

        Date now = new Date();
        Date expiryDate = new Date(now.getTime() + EXPIRED_TIME);

        Map<String,Object> claims = new LinkedHashMap<>();
        claims.put("id", user.getId()+"");
        claims.put("username", user.getUsername());
        claims.put("name", user.getName());
        if(!Objects.isNull(user.getAuthorities())){
            claims.put("authorities",String.join(CLAIM_DELIMETER,user.getAuthorities()));
        }

        return Jwts.builder()
                .setClaims(claims)
                .setIssuedAt(new Date())
                .setExpiration(expiryDate)
                .signWith(SignatureAlgorithm.HS512, SECRET_KEY)
                .compact();

    }


    public  TokenResponse validateToken(String authToken) {
        TokenResponse builder = TokenResponse.builder().success(true).build();
        try {
            Jwts.parser().setSigningKey(SECRET_KEY).parseClaimsJws(authToken);
        } catch (Throwable ex) {
            builder.setSuccess(false);
            log.error(ex.getMessage());
        }
        return builder;
    }
}
