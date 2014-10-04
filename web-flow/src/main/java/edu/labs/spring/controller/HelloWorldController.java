package edu.labs.spring.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author: Sergey Royz
 * Date: 03.10.2014
 */
@Controller
public class HelloWorldController {

    @RequestMapping("/")
    public String helloWorld() {
        return "redirect:hello";
    }

}
