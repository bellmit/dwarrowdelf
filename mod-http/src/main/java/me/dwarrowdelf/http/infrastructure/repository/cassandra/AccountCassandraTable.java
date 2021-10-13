package me.dwarrowdelf.http.infrastructure.repository.cassandra;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.cassandra.core.cql.PrimaryKeyType;
import org.springframework.data.cassandra.core.mapping.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Table("accounts")
public class AccountCassandraTable {

	public static String createTableCql(String keySpace) {
		return String.format("CREATE TABLE IF NOT EXISTS %s.accounts( no int, balance bigint, PRIMARY KEY ((no)) );",
				keySpace);
	}

	@Data
	@AllArgsConstructor
	@NoArgsConstructor
	@PrimaryKeyClass
	public static class Key {

		@PrimaryKeyColumn(name = "no", ordinal = 0, type = PrimaryKeyType.PARTITIONED)
		private Integer no;

	}

	@PrimaryKey
	private Key key;

	@Column("balance")
	private Long balance;

}
