package com.silionie.server.jwt.security;

import io.jsonwebtoken.*;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;
import java.util.Date;
import java.util.List;

import static com.silionie.server.jwt.security.Constants.*;

@Component
public class TokenProvider {

   @Autowired
   private UserDetailsService userDetailsService;

    public String createToken(String username, List<String> roles) {
       Claims claims = Jwts.claims().setSubject(username);
       claims.put("roles", roles);

       Date now = new Date();
       Date validity = new Date(now.getTime() + EXPIRATION_TIME_MILLIS);

        return Jwts.builder()
                .setClaims(claims)
                .signWith(SignatureAlgorithm.HS256, SECRET_KEY)
                .setIssuedAt(new Date(System.currentTimeMillis()))
                .setExpiration(validity)
                .compact();
    }

    public String getUserNameFromToken(String token){
       return Jwts.parser().setSigningKey(SECRET_KEY).parseClaimsJws(token).getBody().getSubject();
    }

    public String resolveToken(HttpServletRequest request) {
       String bearerToken = request.getHeader(HEADER_STRING);
       if(bearerToken != null && bearerToken.startsWith(TOKEN_PREFIX)){
           return bearerToken.substring(7);
       }
      return null;
    }

   public Boolean validateToken(String token){
       Date expiration = Jwts.parser().setSigningKey(SECRET_KEY)
               .parseClaimsJws(token)
               .getBody()
               .getExpiration();
      return (!expiration.before(new Date())
      );
   }


}
