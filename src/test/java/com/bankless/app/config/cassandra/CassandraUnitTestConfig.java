package com.bankless.app.config.cassandra;

import org.apache.thrift.transport.TTransportException;
import org.cassandraunit.utils.EmbeddedCassandraServerHelper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.config.BeanFactoryPostProcessor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import java.io.IOException;

@Configuration
@Profile("test")
public class CassandraUnitTestConfig {

	private static final Logger LOGGER = LoggerFactory.getLogger(CassandraUnitTestConfig.class);

	public CassandraUnitTestConfig() {
	}

	@Bean
	BeanFactoryPostProcessor cassandraUnitTest() {
		return (beanFactory) -> {
			LOGGER.info("Starting test embedded Cassandra");
			try {
				EmbeddedCassandraServerHelper.startEmbeddedCassandra();
			}
			catch (IOException | InterruptedException | TTransportException exception) {
				LOGGER.error("Unable to start test embedded Cassandra", exception);
				throw new IllegalStateException("Unable to start test CassandraUnit", exception);
			}

		};
	}

}
