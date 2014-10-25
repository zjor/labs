package edu.labs.spring.security;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service("acmeUserDetailsService")
public class AcmeUserDetailsService implements UserDetailsService {

    private static final Map<String, UserDetails> users = new HashMap<>();

    /**
     * Hash of "p@ssword"
     */
    private static final String PASSWORD_HASH = "85ff1918ac48bf4d5eac230de1c81bfbb4672ef6fb0a56e1bce83673d99b6b886f2b393b4e57e595";

    static {
        users.put("elvira", new UserDetailsImpl("elvira", "Elvira Bramborova", PASSWORD_HASH, new String[] {"user"}));
        users.put("juan", new UserDetailsImpl("juan", "Juan Rodrigez", PASSWORD_HASH, new String[] {"user", "root"}));
    }

    @Override
    public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {
        UserDetails user = users.get(s);
        if (user == null) {
            throw new UsernameNotFoundException(s);
        }
        return user;
    }
}
