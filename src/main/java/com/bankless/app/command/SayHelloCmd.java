package com.bankless.app.command;

import com.bankless.domain.model.Greeting;
import com.bankless.domain.service.GreetingService;
import com.bankless.infrastructure.dto.SayHelloRequest;
import com.bankless.infrastructure.dto.SayHelloResponse;

public class SayHelloCmd extends Command {

    private GreetingService greetingService = new GreetingService();

    public SayHelloResponse execute(SayHelloRequest request) {
        Greeting greeting = greetingService.sayHelloTo( request.getName() );
        return new SayHelloResponse( greeting );
    }

}
