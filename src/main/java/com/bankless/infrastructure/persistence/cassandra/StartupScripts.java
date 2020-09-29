package com.bankless.infrastructure.persistence.cassandra;

import java.util.List;
import com.bankless.infrastructure.persistence.cassandra.table.AccountTable;
import com.google.common.collect.ImmutableList;

public class StartupScripts {

	public static List<String> getCreationScripts(String keySpace) {

		String createAccounts = AccountTable.createTableCql(keySpace);

		return ImmutableList.of(createAccounts);

	}

}
