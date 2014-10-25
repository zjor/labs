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

    static {
        users.put("elvira", new UserDetailsImpl("elvira", "Elvira Bramborova", "p@ssword", new String[] {"user"}));
        users.put("juan", new UserDetailsImpl("juan", "Juan Rodrigez", "p@ssword", new String[] {"user", "root"}));
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
