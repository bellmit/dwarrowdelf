package com.bankless.core.infrastructure.service.impl;

import com.bankless.core.infrastructure.service.EventService;
import org.springframework.util.StringUtils;

public class EventServiceKafka implements EventService {

    public String publish( String message ) {
        if (StringUtils.isEmpty( message )) {
            return "There is no message to publish to Kafka";
        } else {
            System.out.println( message );
            return "Message published to Kafka";
        }
    }

}
