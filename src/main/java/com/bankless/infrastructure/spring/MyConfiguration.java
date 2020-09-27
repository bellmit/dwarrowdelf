package com.bankless.infrastructure.spring;

import com.bankless.infrastructure.service.EventService;
import com.bankless.infrastructure.service.impl.EventServiceConsole;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class MyConfiguration {

    @Bean
    public EventService eventService() {
        return new EventServiceConsole();
    }

}
