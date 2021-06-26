package com.erebor.infrastructure.persistence.cassandra.table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.cassandra.core.cql.PrimaryKeyType;
import org.springframework.data.cassandra.core.mapping.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(AccountCassandraTable.ACCOUNTS_TABLE)
public class AccountCassandraTable {

	public static final String ACCOUNTS_TABLE = "accounts";

	public static String createTableCql(String keySpace) {
		return String.format("CREATE TABLE IF NOT EXISTS " + "%s.%s(" + " country_code text," + " no int,"
				+ " balance bigint," + " PRIMARY KEY ((country_code), no)" + ");", keySpace, ACCOUNTS_TABLE);
	}

	@Data
	@AllArgsConstructor
	@NoArgsConstructor
	@PrimaryKeyClass
	public static class Key {

		@PrimaryKeyColumn(name = "country_code", ordinal = 0, type = PrimaryKeyType.PARTITIONED)
		private String countryCode;

		@PrimaryKeyColumn(name = "no", ordinal = 0, type = PrimaryKeyType.CLUSTERED)
		private int no;

	}

	@PrimaryKey
	private AccountCassandraTable.Key key;

	@Column("balance")
	private long balance;

}
