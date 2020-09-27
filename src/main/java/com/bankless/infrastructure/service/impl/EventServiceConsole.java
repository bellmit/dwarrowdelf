package com.bankless.infrastructure.service.impl;

import com.bankless.infrastructure.service.EventService;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

@Service
public class EventServiceConsole implements EventService {

    @Value("${service.console.template}")
    private String template;

    public String publish( String message ) {
        if (StringUtils.isEmpty( message )) {
            return "There is no message to publish to console";
        } else {
            String msg = String.format(template, message);
            System.out.println( msg );
            return "Message published to console";
        }
    }

}
