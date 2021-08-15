package me.dwarrowdelf.http.app.config;

import me.dwarrowdelf.http.app.kafka.AccountOpenedPublisher;
import me.dwarrowdelf.http.app.kafka.AccountOpenedSubscriber;
import me.dwarrowdelf.http.domain.repository.AccountRepository;
import me.dwarrowdelf.http.infrastructure.repository.AccountRepositoryInCassandra;
import me.dwarrowdelf.http.infrastructure.persistence.cassandra.repository.AccountCassandraRepo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

@Configuration
@Profile("test")
public class TestContextConfig {

	private static final Logger LOGGER = LoggerFactory.getLogger(TestContextConfig.class);

	@Bean
	AccountRepository bindAccountRepository(AccountCassandraRepo accountCassandraRepo) {
		LOGGER.info("Binding account repository to test context");
		return new AccountRepositoryInCassandra(accountCassandraRepo);
	}

	@Bean
	public AccountOpenedSubscriber bindAccountOpenedSubscriber() {
		return new AccountOpenedSubscriber();
	}

	@Bean
	public AccountOpenedPublisher bindAccountOpenedPublisher() {
		return new AccountOpenedPublisher();
	}

}
