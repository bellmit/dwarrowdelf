package me.khazaddum.mordor.app.command;

import me.khazaddum.mordor.domain.model.Greeting;
import me.khazaddum.mordor.domain.service.GreetingService;
import me.khazaddum.mordor.infrastructure.dto.SayHelloRequest;
import me.khazaddum.mordor.infrastructure.dto.SayHelloResponse;

public class SayHelloCmd extends Command {

    private GreetingService greetingService = new GreetingService();

    public SayHelloResponse execute(SayHelloRequest request) {
        Greeting greeting = greetingService.sayHelloTo( request.getName() );
        return new SayHelloResponse( greeting );
    }

}
