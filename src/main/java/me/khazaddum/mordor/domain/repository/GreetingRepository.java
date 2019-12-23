package me.khazaddum.mordor.domain.repository;

import me.khazaddum.mordor.domain.model.Greeting;

public interface GreetingRepository {

    String upsert(Greeting greeting );

}
