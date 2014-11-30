package edu.labs.spring.cxf;

import javax.jws.WebService;
import java.util.Date;

@WebService(endpointInterface = "edu.labs.spring.cxf.SampleWebService")
public class SampleWebServiceImpl implements SampleWebService {

    @Override
    public String echo(String input) {
        return input;
    }

    @Override
    public String getDate() {
        return (new Date()).toString();
    }
}
