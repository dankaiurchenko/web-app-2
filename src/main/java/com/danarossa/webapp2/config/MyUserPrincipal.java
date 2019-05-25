package com.danarossa.webapp2.config;

import com.danarossa.webapp2.data.User;
import lombok.extern.log4j.Log4j2;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

@Log4j2
public class MyUserPrincipal extends User implements UserDetails {

    public MyUserPrincipal(User user) {
        super(user.getUserId(), user.getEmail(), user.getPassword(),
                user.getName(), user.getSurname(),
                user.getDateEntered(), user.getRole());
        log.info("Got the user" + user);
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        Set<GrantedAuthority> grantedAuthoritySet = new HashSet<>();
        grantedAuthoritySet.add(new SimpleGrantedAuthority(getRole().name()));
        return grantedAuthoritySet;
    }

    @Override
    public String getPassword() {
        log.info("Returning password " + super.getPassword());
        return super.getPassword();
    }

    @Override
    public String getUsername() {
        return getEmail();
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }
}
