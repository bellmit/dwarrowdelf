package me.dwarrowdelf.http.infrastructure.persistence.cassandra;

import java.util.List;

import me.dwarrowdelf.http.infrastructure.persistence.cassandra.table.AccountCassandraTable;
import com.google.common.collect.ImmutableList;

public class StartupScripts {

	public static List<String> getCreationScripts(String keySpace) {

		String createAccounts = AccountCassandraTable.createTableCql(keySpace);

		return ImmutableList.of(createAccounts);

	}

}