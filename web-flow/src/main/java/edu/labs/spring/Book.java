package edu.labs.spring;

import lombok.Data;

import java.io.Serializable;

/**
 * @author: Sergey Royz
 * Date: 07.10.2014
 */
@Data
public class Book implements Serializable {

    private String author;
    private String title;

}
