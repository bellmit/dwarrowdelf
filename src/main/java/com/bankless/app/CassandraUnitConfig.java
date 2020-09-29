package com.bankless.app;

import org.apache.thrift.transport.TTransportException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.config.BeanFactoryPostProcessor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.cassandraunit.utils.EmbeddedCassandraServerHelper;
import java.io.IOException;

@Configuration
public class CassandraUnitConfig {

	private static final Logger LOGGER = LoggerFactory.getLogger(CassandraUnitConfig.class);

	public CassandraUnitConfig() {
	}

	@Bean
	BeanFactoryPostProcessor cassandraUnit() {
		return (beanFactory) -> {
			LOGGER.info("Starting embedded Cassandra");
			try {
				EmbeddedCassandraServerHelper.startEmbeddedCassandra();
			}
			catch (IOException | InterruptedException | TTransportException exception) {
				LOGGER.error("Unable to start embedded Cassandra", exception);
				throw new IllegalStateException("Unable to start CassandraUnit", exception);
			}

		};
	}

}
