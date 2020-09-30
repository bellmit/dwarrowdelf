package com.bankless.app.config;

import com.bankless.infrastructure.persistence.cassandra.StartupScripts;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.ApplicationRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.core.io.ClassPathResource;
import org.springframework.data.cassandra.core.CassandraTemplate;

import java.io.File;
import java.nio.file.Files;
import java.util.List;

@Configuration
@Profile("test")
public class TestCassandraConfig {

	private static final Logger LOGGER = LoggerFactory.getLogger(TestCassandraConfig.class);

	// FIXME. unable to start local JMX service
	// 2020-09-29 16:44:36.749 ERROR 5649 --- [pool-2-thread-1]
	// o.a.cassandra.service.StartupChecks : cassandra.jmx.local.port missing from
	// cassandra-env.sh, unable to start local JMX service.

	@Value("${cassandra.keyspace}")
	private String keyspace;

	@Bean
	ApplicationRunner applicationRunner(CassandraTemplate template) {
		return args -> {
			LOGGER.info("Creating tables");
			for (String statement : StartupScripts.getCreationScripts(keyspace)) {
				template.getCqlOperations().execute(statement);
			}
			LOGGER.info("Inserting test records into accounts table");
			for (String statement : getInsertRows("test-accounts.sql")) {
				template.getCqlOperations().execute(statement);
			}
		};
	}

	private List<String> getInsertRows(String fileName) {
		try {
			File file = new ClassPathResource(fileName).getFile();
			return Files.readAllLines(file.toPath());
		}
		catch (Exception ex) {
			throw new RuntimeException(String.format("Unable to get insert rows from file %s", fileName), ex);
		}
	}

}
