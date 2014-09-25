package edu.labs.registration.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author: Sergey Royz
 * Date: 22.09.2014
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Member {

    private String username;
    private String firstName;
    private String lastName;
    private String email;
    private boolean verified;

}
