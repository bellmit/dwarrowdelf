package me.dwarrowdelf.http.app.config;

import com.google.common.collect.ImmutableList;
import me.dwarrowdelf.http.infrastructure.repository.cassandra.AccountCassandraTable;
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
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

@Configuration
@Profile("local")
public class LocalCassandraConfig {

	private static final Logger LOGGER = LoggerFactory.getLogger(LocalCassandraConfig.class);

	@Value("${cassandra.keyspace}")
	private String keyspace;

	@Bean
	ApplicationRunner applicationRunner(CassandraTemplate template) {
		return args -> {

			LOGGER.info("Creating tables");
			String createAccounts = AccountCassandraTable.createTableCql(keyspace);
			template.getCqlOperations().execute(createAccounts);

			LOGGER.info("Inserting records");
			loadDbScripts().forEach(statement -> template.getCqlOperations().execute(statement));

		};
	}

	private List<String> loadDbScripts() {
		return ImmutableList.of("insert into accounts( no, balance ) values ( 80001, 5000000 );",
				"insert into accounts( no, balance ) values ( 80002, 20000 );");
	}

}
