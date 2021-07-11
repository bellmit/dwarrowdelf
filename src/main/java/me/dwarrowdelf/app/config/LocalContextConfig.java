package me.dwarrowdelf.app.config;

import me.dwarrowdelf.app.kafka.AccountOpenedPublisher;
import me.dwarrowdelf.app.kafka.AccountOpenedSubscriber;
import me.dwarrowdelf.domain.repository.AccountRepository;
import me.dwarrowdelf.infrastructure.persistence.cassandra.repository.AccountCassandraRepo;
import me.dwarrowdelf.infrastructure.repository.AccountRepositoryInCassandra;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.data.cassandra.repository.config.EnableCassandraRepositories;

@Configuration
@Profile("local")
@EnableCassandraRepositories("com.bankless.infrastructure.persistence.cassandra")
public class LocalContextConfig {

	private static final Logger LOGGER = LoggerFactory.getLogger(LocalContextConfig.class);

	@Bean
	public AccountRepository bindAccountRepository(AccountCassandraRepo accountCassandraRepo) {
		LOGGER.info("Binding account repository to local context");
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
