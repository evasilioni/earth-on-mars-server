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

@Component
public class TokenProvider {

    private String secretKey = "secret";
    private long expirationTimeInMillis = 1800000;  // 30min

   @Autowired
   private UserDetailsService userDetailsService;

   public String createToken(String username, List<String> roles) {
       Claims claims = Jwts.claims().setSubject(username);
       claims.put("roles", roles);

       Date now = new Date();
       Date validity = new Date(now.getTime() + expirationTimeInMillis);

        return Jwts.builder()
                .setClaims(claims)
                .signWith(SignatureAlgorithm.HS256, secretKey)
                .setIssuedAt(new Date(System.currentTimeMillis()))
                .setExpiration(validity)
                .compact();
    }

    public Authentication getAuthentication(String token){
       UserDetails userDetails = this.userDetailsService.loadUserByUsername(getUserNameFromToken(token));
       return new UsernamePasswordAuthenticationToken(userDetails, "", userDetails.getAuthorities());
    }

    public String getUserNameFromToken(String token){
       return Jwts.parser().setSigningKey(secretKey).parseClaimsJws(token).getBody().getSubject();
    }

    public String resolveToken(HttpServletRequest request) {
       String bearerToken = request.getHeader("Authorisation");
       if(bearerToken != null && bearerToken.startsWith("Bearer ")){
           return bearerToken.substring(7);
       }
      return null;
    }

   public Boolean validateToken(String token, String uname){
      final String username = getUserNameFromToken(token);
      Jwt<Header, Claims> claims = Jwts
              .parser()
              .setSigningKey(secretKey)
              .parseClaimsJwt(token);

      return (
              username.equals(uname)
                      && !claims.getBody().getExpiration().before(new Date())
      );
   }


}
