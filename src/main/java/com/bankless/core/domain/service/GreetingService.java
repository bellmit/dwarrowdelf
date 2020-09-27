package com.bankless.core.domain.service;

import com.bankless.core.domain.model.Greeting;
import org.springframework.util.StringUtils;
import java.util.concurrent.atomic.AtomicLong;

public class GreetingService {

    private static final String template = "Hello, %s!";
    private final AtomicLong counter = new AtomicLong();

    public Greeting sayHelloTo( String name ) {

        if ( !StringUtils.isEmpty(name) ) {
            return new Greeting(counter.incrementAndGet(), String.format(template, name));
        } else {
            return new Greeting(counter.incrementAndGet(), String.format(template, "World"));
        }

    }

}
