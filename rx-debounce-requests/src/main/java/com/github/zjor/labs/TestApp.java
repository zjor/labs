package com.github.zjor.labs;

import com.github.zjor.labs.service.Event;
import com.github.zjor.labs.service.EventA;
import com.github.zjor.labs.service.EventB;
import rx.Observable;

public class TestApp {
    public static void main(String[] args) {
        Observable<Event> stream = Observable.from(new Event[]{
                new EventA("1"),
                new EventB("1"),
                new EventB("2"),
                new EventA("2"),
                new EventA("3"),
        });
        stream.groupBy(e -> e.getClass()).subscribe(g1 -> {
            g1.groupBy(e -> e.getId()).subscribe(g2 -> {
                g2.subscribe(e -> {
                    System.out.println(g1.getKey() + ": " + g2.getKey());
                });
            });
        });
    }
}
