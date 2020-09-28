package com.bankless.domain.repository;

import com.bankless.domain.model.Greeting;

public interface GreetingRepository {

	String upsert(Greeting greeting);

}
