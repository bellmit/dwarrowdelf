package com.erebor.app.config.cassandra;

import org.apache.thrift.transport.TTransportException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.config.BeanFactoryPostProcessor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.cassandraunit.utils.EmbeddedCassandraServerHelper;
import org.springframework.context.annotation.Profile;

import java.io.IOException;

@Configuration
@Profile("local")
public class EmbeddedCassandraServerConfig {

	private static final Logger LOGGER = LoggerFactory.getLogger(EmbeddedCassandraServerConfig.class);

	public EmbeddedCassandraServerConfig() {
	}

	@Bean
	BeanFactoryPostProcessor cassandraUnitLocal() {
		return (beanFactory) -> {
			LOGGER.info("Starting local embedded Cassandra");
			try {
				EmbeddedCassandraServerHelper.startEmbeddedCassandra();
			}
			catch (IOException | InterruptedException | TTransportException exception) {
				LOGGER.error("Unable to start local embedded Cassandra", exception);
				throw new IllegalStateException("Unable to start local CassandraUnit", exception);
			}

		};
	}

}
