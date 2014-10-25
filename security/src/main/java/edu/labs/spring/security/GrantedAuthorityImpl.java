package edu.labs.spring.security;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.security.core.GrantedAuthority;

/**
 * @author: Sergey Royz
 * Date: 25.10.2014
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class GrantedAuthorityImpl implements GrantedAuthority {

    private String authority;

    @Override
    public String getAuthority() {
        return authority;
    }
}
