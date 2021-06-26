package com.erebor.app.config.cassandra;

import com.datastax.driver.core.AuthProvider;
import com.datastax.driver.core.PlainTextAuthProvider;
import com.datastax.oss.driver.shaded.guava.common.collect.Lists;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.context.annotation.Profile;
import org.springframework.data.cassandra.config.AbstractCassandraConfiguration;
import org.springframework.data.cassandra.config.CassandraClusterFactoryBean;
import org.springframework.data.cassandra.core.cql.keyspace.CreateKeyspaceSpecification;
import org.springframework.data.cassandra.core.cql.keyspace.DataCenterReplication;

import java.util.List;

@Configuration
@Profile("test")
@Import({ EmbeddedCassandraTestProperties.class })
public class EmbeddedCassandraTestConfig extends AbstractCassandraConfiguration {

	protected final EmbeddedCassandraTestProperties props;

	protected EmbeddedCassandraTestConfig(EmbeddedCassandraTestProperties embeddedCassandraTestProperties) {
		this.props = embeddedCassandraTestProperties;
	}

	protected String getKeyspaceName() {
		return this.props.getKeyspace();
	}

	protected int getPort() {
		return this.props.getService().getPort();
	}

	protected String getContactPoints() {
		return this.props.getService().getHost();
	}

	protected AuthProvider getAuthProvider() {
		return new PlainTextAuthProvider(this.props.getUsername(), this.props.getPassword());
	}

	protected List<CreateKeyspaceSpecification> getKeyspaceCreations() {
		if (this.props.isAutoinit() && this.props.isSimplestrategy()) {
			CreateKeyspaceSpecification specification = CreateKeyspaceSpecification
					.createKeyspace(this.props.getKeyspace()).ifNotExists()
					.withSimpleReplication((long) this.props.getReplication().getFactor());
			return Lists.newArrayList(specification);
		}
		else if (this.props.isSimplestrategy()) {
			DataCenterReplication dataCenterReplication = DataCenterReplication.of(this.props.getDatacenter(),
					(long) this.props.getReplication().getFactor());
			CreateKeyspaceSpecification specification = CreateKeyspaceSpecification
					.createKeyspace(this.props.getKeyspace()).ifNotExists()
					.withNetworkReplication(dataCenterReplication);
			return Lists.newArrayList(specification);
		}
		else {
			return Lists.newArrayList();
		}
	}

	public CassandraClusterFactoryBean cluster() {
		CassandraClusterFactoryBean cluster = super.cluster();
		cluster.setJmxReportingEnabled(false);
		return cluster;
	}

}
