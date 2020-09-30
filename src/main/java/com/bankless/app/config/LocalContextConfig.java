package com.bankless.app.config;

import com.bankless.domain.repository.AccountRepository;
import com.bankless.infrastructure.persistence.cassandra.StartupScripts;
import com.bankless.infrastructure.persistence.cassandra.repository.AccountCassandraRepo;
import com.bankless.infrastructure.repository.AccountRepositoryInCassandra;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.ApplicationRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.core.io.ClassPathResource;
import org.springframework.data.cassandra.core.CassandraTemplate;
import org.springframework.data.cassandra.repository.config.EnableCassandraRepositories;

import java.io.File;
import java.nio.file.Files;
import java.util.List;

@Configuration
@Profile("local")
@EnableCassandraRepositories("com.bankless.infrastructure.persistence.cassandra")
public class LocalContextConfig {

	private static final Logger LOGGER = LoggerFactory.getLogger(LocalContextConfig.class);

	@Bean
	AccountRepository bindAccountRepository(AccountCassandraRepo accountCassandraRepo) {
		LOGGER.info("Binding account repository to local context");
		return new AccountRepositoryInCassandra(accountCassandraRepo);
	}

}
