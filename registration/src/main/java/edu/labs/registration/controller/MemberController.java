package edu.labs.registration.controller;

import edu.labs.registration.model.Member;
import edu.labs.registration.repository.MemberRepository;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.inject.Inject;
import java.util.List;

/**
 * @author: Sergey Royz
 * Date: 22.09.2014
 */
@Controller
public class MemberController {

    @Inject
    private MemberRepository members;

    @RequestMapping(value = "/members", method = RequestMethod.GET, produces = "application/json")
    @ResponseBody
    public List<Member> getMembers() {
        return members.findAll();
    }

    @RequestMapping(value = "/new", method = RequestMethod.POST)
    @ResponseBody
    public void register(
            @RequestParam("firstName") String firstName,
            @RequestParam("lastName") String lastName,
            @RequestParam("username") String username,
            @RequestParam("email") String email
    ) {
        members.save(new Member(username, firstName, lastName, email));
    }

}
