package com.bankless.core.domain.repository;

import com.bankless.core.domain.model.Greeting;

public interface GreetingRepository {

    String upsert(Greeting greeting );

}
