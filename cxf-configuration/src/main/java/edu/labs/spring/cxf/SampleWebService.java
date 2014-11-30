package edu.labs.spring.cxf;

import javax.jws.WebService;

@WebService
public interface SampleWebService {

    String echo(String input);

    String getDate();

}
