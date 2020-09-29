package com.bankless.infrastructure.persistence.cassandra.table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.cassandra.core.cql.PrimaryKeyType;
import org.springframework.data.cassandra.core.mapping.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(AccountTable.ACCOUNTS_TABLE)
public class AccountTable {

	public static final String ACCOUNTS_TABLE = "accounts";

	public static String createTableCql(String keySpace) {
		return String.format("CREATE TABLE IF NOT EXISTS " + "%s.%s(" + " country_code text," + " no number,"
				+ " balance number," + " PRIMARY KEY ((country_code), no)" + ");", keySpace, ACCOUNTS_TABLE);
	}

	@Data
	@AllArgsConstructor
	@NoArgsConstructor
	@PrimaryKeyClass
	public static class Key {

		@PrimaryKeyColumn(name = "country_code", ordinal = 0, type = PrimaryKeyType.PARTITIONED)
		private String tenantId;

		@PrimaryKeyColumn(name = "no", ordinal = 0, type = PrimaryKeyType.CLUSTERED)
		private String menuId;

	}

	@PrimaryKey
	private AccountTable.Key key;

	@Column("country_code")
	private String countryCode;

	@Column("no")
	private long AccountNo;

	@Column("balance")
	private long balance;

}
