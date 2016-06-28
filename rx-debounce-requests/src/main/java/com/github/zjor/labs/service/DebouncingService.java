package com.github.zjor.labs.service;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import rx.subjects.PublishSubject;
import rx.subjects.Subject;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.TimeUnit;

@Slf4j
@Service
public class DebouncingService {

    private Map<Class<?>, Map<String, Integer>> requests = new ConcurrentHashMap<>();

    private Subject<Event, Event> events = PublishSubject.create();

    {
        events.groupBy(e -> e.getClass()).subscribe(typedStream -> {
            Class<? extends Event> clazz = typedStream.getKey();
            requests.putIfAbsent(clazz, new ConcurrentHashMap<>());
            typedStream.groupBy(e -> e.getId()).subscribe(idStream -> {
                idStream.throttleFirst(5, TimeUnit.SECONDS).subscribe(e -> {
                    String id = idStream.getKey();
                    log.info("Class: {}; ID: {}", clazz, id);
                    synchronized (requests) {
                        requests.get(clazz).putIfAbsent(id, 0);
                        requests.get(clazz).put(id, requests.get(clazz).get(id) + 1);
                    }
                });
            });
        });

    }

    public Integer service(Event e) {
        events.onNext(e);
        return requests.get(e.getClass()).get(e.getId());
    }

}
