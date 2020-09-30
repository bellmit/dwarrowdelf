package com.bankless.infrastructure.repository;

import com.bankless.app.config.cassandra.CassandraUnitConfig;
import com.bankless.domain.model.Account;
import com.bankless.domain.repository.AccountRepository;
import com.bankless.infrastructure.persistence.cassandra.repository.AccountCassandraRepo;
import com.bankless.infrastructure.persistence.cassandra.table.AccountCassandraTable;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import java.util.Optional;

public class AccountRepositoryInCassandra implements AccountRepository {

	private static final Logger LOGGER = LoggerFactory.getLogger(AccountRepositoryInCassandra.class);

	private final AccountCassandraRepo accountCassandraRepo;

	public AccountRepositoryInCassandra(AccountCassandraRepo accountCassandraRepo) {
		this.accountCassandraRepo = accountCassandraRepo;
	}

	public Optional<Account> find(String countryCode, int no) {
		AccountCassandraTable.Key key = new AccountCassandraTable.Key(countryCode, no);
		return accountCassandraRepo.findById(key).map(table -> {
			return new Account(table.getKey().getCountryCode(), table.getKey().getNo(), table.getBalance());
		});
	}

}
