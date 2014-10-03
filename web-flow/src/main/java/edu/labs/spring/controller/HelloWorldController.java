package edu.labs.spring.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @author: Sergey Royz
 * Date: 03.10.2014
 */
@Controller
public class HelloWorldController {

    @RequestMapping("/")
    @ResponseBody
    public String helloWorld() {
        return "Hello world";
    }

}
