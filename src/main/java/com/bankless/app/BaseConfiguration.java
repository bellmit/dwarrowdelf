package com.bankless.app;

import com.bankless.domain.service.GreetingService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class BaseConfiguration {

    private static final Logger LOG = LoggerFactory.getLogger(BaseConfiguration.class);

    @Bean
    public GreetingService greetingService() {
        LOG.info("Binding greetingService");
        return new GreetingService();
    }

}
