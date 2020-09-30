package com.bankless.app.config;

import com.bankless.domain.repository.AccountRepository;
import com.bankless.infrastructure.persistence.cassandra.repository.AccountCassandraRepo;
import com.bankless.infrastructure.repository.AccountRepositoryInCassandra;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.data.cassandra.repository.config.EnableCassandraRepositories;

@Configuration
@Profile("test")
public class TestContextConfig {

	private static final Logger LOGGER = LoggerFactory.getLogger(TestContextConfig.class);

	@Bean
	AccountRepository bindAccountRepository(AccountCassandraRepo accountCassandraRepo) {
		LOGGER.info("Binding account repository to test context");
		return new AccountRepositoryInCassandra(accountCassandraRepo);
	}

}
