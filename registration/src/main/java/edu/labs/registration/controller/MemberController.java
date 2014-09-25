package edu.labs.registration.controller;

import edu.labs.registration.model.Member;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;
import java.util.List;

/**
 * @author: Sergey Royz
 * Date: 22.09.2014
 */
@Controller
public class MemberController {

    private List<Member> members = new ArrayList<Member>();

    {
        members.add(new Member("zjor", "Sergey", "Royz", "zjor.se@gmail.com", true));
        members.add(new Member("alice", "Alice", "Burton", "alice.burton@hotmail.com", false));
        members.add(new Member("bob", "Bob", "Davis", "bobdav@gmail.com", true));
        members.add(new Member("jane83", "Jane", "Curtis", "janec83@gmail.com", false));
        members.add(new Member("dave", "David", "Flamber", "dave.flamber@gmail.com", true));
        members.add(new Member("kim", "Veronika", "Kim", "veronika@gmail.com", true));
    }

    @RequestMapping(value = "/members", method = RequestMethod.GET, produces = "application/json")
    @ResponseBody
    public List<Member> getMembers() {
        return members;
    }

    @RequestMapping(value = "/new", method = RequestMethod.POST)
    @ResponseBody
    public void register(
            @RequestParam("firstName") String firstName,
            @RequestParam("lastName") String lastName,
            @RequestParam("username") String username,
            @RequestParam("email") String email
    ) {
        members.add(new Member(username, firstName, lastName, email, false));
    }

}
