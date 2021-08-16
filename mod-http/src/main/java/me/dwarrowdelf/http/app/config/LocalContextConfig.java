package me.dwarrowdelf.http.app.config;

import me.dwarrowdelf.http.domain.repository.AccountRepository;
import me.dwarrowdelf.http.infrastructure.repository.AccountRepositoryInCassandra;
import me.dwarrowdelf.http.infrastructure.repository.cassandra.AccountCassandraRepo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.data.cassandra.repository.config.EnableCassandraRepositories;

@Configuration
@Profile("local")
@EnableCassandraRepositories("me.dwarrowdelf.http.infrastructure.repository.cassandra")
public class LocalContextConfig {

	private static final Logger LOGGER = LoggerFactory.getLogger(LocalContextConfig.class);

	@Bean
	public AccountRepository bindAccountRepository(AccountCassandraRepo accountCassandraRepo) {
		LOGGER.info("Binding account repository to local context");
		return new AccountRepositoryInCassandra(accountCassandraRepo);
	}

}
