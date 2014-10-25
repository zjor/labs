package edu.labs.spring.security;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.security.crypto.password.PasswordEncoder;

/**
 * @author: Sergey Royz
 * Date: 25.10.2014
 */
public class PasswordHashGenerator {

    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext(new String[] {"beans-service.xml"});

        PasswordEncoder passwordEncoder = (PasswordEncoder) context.getBean("passwordEncoder");

        System.out.println(passwordEncoder.encode("p@ssword"));

    }

}
