package com.resolved.userservice.jwt;

import com.auth0.jwt.JWT;
import com.auth0.jwt.interfaces.DecodedJWT;

import java.util.Date;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;

import java.util.function.Function;

public class JwtHandler {

    public String getUsernameByToken(String token){
        DecodedJWT jwt = JWT.decode(token);
//        jwt.
        return jwt.getSubject();
    }

//    public Boolean validateToken(String token) {
//        return (!isTokenExpired(token));
//    }
//
//    private Boolean isTokenExpired(String token) {
//        final var expiration = getExpirationDateFromToken(token);
//        return expiration.before(new Date());
//    }

}
