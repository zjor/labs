package com.github.zjor.labs.controller;

import com.github.zjor.labs.service.DebouncingService;
import com.github.zjor.labs.service.EventA;
import com.github.zjor.labs.service.EventB;
import lombok.extern.slf4j.Slf4j;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.QueryParam;
import java.util.HashMap;
import java.util.Map;

@Slf4j
@Path("api")
public class Controller {

    private Map<String, Map<String, Integer>> requests = new HashMap<>();

    private DebouncingService service;

    public Controller(DebouncingService service) {
        this.service = service;
    }

    @GET
    @Path("a")
    public String getA(@QueryParam("id") String id) {
        log.info("id: {}", id);
        int actual = incAndGet("a", id);
        int debounced = service.service(new EventA(id));
        return "Request ID: " + actual + "<br/>Debounced ID: " + debounced;
    }

    @GET
    @Path("b")
    public String getB(@QueryParam("id") String id) {
        log.info("id: {}", id);
        int actual = incAndGet("b", id);
        int debounced = service.service(new EventB(id));
        return "Request ID: " + actual + "<br/>Debounced ID: " + debounced;
    }

    private int incAndGet(String type, String id) {
        synchronized (requests) {
            requests.putIfAbsent(type, new HashMap<>());
            HashMap<String, Integer> m = (HashMap<String, Integer>) requests.get(type);
            m.putIfAbsent(id, 0);
            m.put(id, m.get(id) + 1);
            return m.get(id);
        }
    }

}
