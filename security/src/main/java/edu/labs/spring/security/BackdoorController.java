package edu.labs.spring.security;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.inject.Inject;

/**
 * @author: Sergey Royz
 * Date: 27.10.2014
 */
@Controller
public class BackdoorController {

    @Inject
    @Qualifier("authenticationManager")
    private AuthenticationManager authenticationManager;

    @RequestMapping(value = "/backdoor/{username}", method = RequestMethod.GET)
    public String authenticate(@PathVariable("username") String username) {
        Authentication authRequest = new UsernamePasswordAuthenticationToken(username, "p@ssword");
        Authentication authResult = authenticationManager.authenticate(authRequest);
        SecurityContextHolder.getContext().setAuthentication(authResult);
        return "redirect:/";
    }
}
