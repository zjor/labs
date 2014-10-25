package edu.labs.spring.security;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

/**
 * @author: Sergey Royz
 * Date: 25.10.2014
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserDetailsImpl implements UserDetails {

    private String username;
    private String fullName;
    private String password;
    private String[] authorities;

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        if (authorities == null) {
            return Collections.emptyList();
        } else {
            List<GrantedAuthority> authorityList = new ArrayList<>();
            for (String a: authorities) {
                authorityList.add(new GrantedAuthorityImpl(a));
            }
            return authorityList;
        }
    }

    @Override
    public String getPassword() {
        return password;
    }

    @Override
    public String getUsername() {
        return username;
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
