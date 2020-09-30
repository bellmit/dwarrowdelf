package com.bankless.app.config.cassandra;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

@Configuration
@ConfigurationProperties("cassandra")
public class CassandraConfigProperties {

	private String username;

	private String password;

	private String keyspace;

	private boolean autoinit;

	private boolean simplestrategy;

	private String datacenter;

	private CassandraConfigProperties.Service service;

	private CassandraConfigProperties.Replication replication;

	public CassandraConfigProperties() {
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getKeyspace() {
		return keyspace;
	}

	public void setKeyspace(String keyspace) {
		this.keyspace = keyspace;
	}

	public boolean isAutoinit() {
		return autoinit;
	}

	public void setAutoinit(boolean autoinit) {
		this.autoinit = autoinit;
	}

	public boolean isSimplestrategy() {
		return simplestrategy;
	}

	public void setSimplestrategy(boolean simplestrategy) {
		this.simplestrategy = simplestrategy;
	}

	public String getDatacenter() {
		return datacenter;
	}

	public void setDatacenter(String datacenter) {
		this.datacenter = datacenter;
	}

	public Service getService() {
		return service;
	}

	public void setService(Service service) {
		this.service = service;
	}

	public Replication getReplication() {
		return replication;
	}

	public void setReplication(Replication replication) {
		this.replication = replication;
	}

	public static class Service {

		private String host;

		private int port;

		public Service() {
		}

		public String getHost() {
			return host;
		}

		public void setHost(String host) {
			this.host = host;
		}

		public int getPort() {
			return port;
		}

		public void setPort(int port) {
			this.port = port;
		}

	}

	public static class Replication {

		private int factor;

		public Replication() {
		}

		public int getFactor() {
			return factor;
		}

		public void setFactor(int factor) {
			this.factor = factor;
		}

	}

}
