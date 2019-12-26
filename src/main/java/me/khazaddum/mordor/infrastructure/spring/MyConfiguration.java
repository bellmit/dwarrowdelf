package me.khazaddum.mordor.infrastructure.spring;

import me.khazaddum.mordor.infrastructure.service.EventService;
import me.khazaddum.mordor.infrastructure.service.impl.EventServiceConsole;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class MyConfiguration {

    @Bean
    public EventService eventService() {
        return new EventServiceConsole();
    }

}
