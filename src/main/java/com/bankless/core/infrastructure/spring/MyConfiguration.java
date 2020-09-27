package com.bankless.core.infrastructure.spring;

import com.bankless.core.infrastructure.service.EventService;
import com.bankless.core.infrastructure.service.impl.EventServiceConsole;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class MyConfiguration {

    @Bean
    public EventService eventService() {
        return new EventServiceConsole();
    }

}
