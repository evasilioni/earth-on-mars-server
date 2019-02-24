package com.silionie.server.jwt.security;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.silionie.server.domain.User;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.Date;
import java.util.List;

import static java.util.stream.Collectors.toList;

public class JwtUser implements UserDetails {

    private final Long id;
    private final String username;
    private final String firstname;
    private final String lastname;
    private final String password;
    private Collection<? extends GrantedAuthority> authorities;

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return authorities;
    }

    @Override
    public String getPassword() {
        return this.password;
    }

    @Override
    public String getUsername() {
        return this.username;
    }

    @JsonIgnore
    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @JsonIgnore
    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @JsonIgnore
    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }

    private JwtUser(JwtUserBuilder builder) {
        this.id = builder.id;
        this.username = builder.username;
        this.firstname = builder.firstname;
        this.lastname = builder.lastname;
        this.password = builder.password;
        this.authorities = builder.authorities;
    }

    //Builder Class
    public static class JwtUserBuilder {

        private Long id;
        private String username;
        private String firstname;
        private String lastname;
        private String password;
        private Collection<? extends GrantedAuthority> authorities;

        public JwtUserBuilder(User user) {
            this.username = user.getUsername();
            this.password = user.getPassword();
            this.authorities = mapToGrantedAuthorities(user.getRoles());
        }

        public JwtUserBuilder setFirstname(String firstname) {
            this.firstname = firstname;
            return this;
        }

        public JwtUserBuilder setLastname(String lastname) {
            this.lastname = lastname;
            return this;
        }

        private static List<GrantedAuthority> mapToGrantedAuthorities(List<String> roles) {
            return roles.stream().map(SimpleGrantedAuthority::new).collect(toList());
        }

        public JwtUser build() {
            return new JwtUser(this);
        }
    }

}
