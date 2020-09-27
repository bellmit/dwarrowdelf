package com.bankless.core.app.command;

import com.bankless.core.domain.model.Greeting;
import com.bankless.core.domain.service.GreetingService;
import com.bankless.core.infrastructure.dto.SayHelloRequest;
import com.bankless.core.infrastructure.dto.SayHelloResponse;

public class SayHelloCmd extends Command {

    private GreetingService greetingService = new GreetingService();

    public SayHelloResponse execute(SayHelloRequest request) {
        Greeting greeting = greetingService.sayHelloTo( request.getName() );
        return new SayHelloResponse( greeting );
    }

}
