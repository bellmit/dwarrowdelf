package me.dwarrowdelf.http.infrastructure.repository;

import me.dwarrowdelf.http.domain.model.Account;
import me.dwarrowdelf.http.domain.repository.AccountRepository;
import me.dwarrowdelf.http.infrastructure.repository.cassandra.AccountCassandraTable;
import me.dwarrowdelf.http.infrastructure.repository.cassandra.AccountCassandraRepo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import java.util.Optional;

public class AccountRepositoryInCassandra implements AccountRepository {

	private static final Logger LOGGER = LoggerFactory.getLogger(AccountRepositoryInCassandra.class);

	private final AccountCassandraRepo accountCassandraRepo;

	public AccountRepositoryInCassandra(AccountCassandraRepo accountCassandraRepo) {
		this.accountCassandraRepo = accountCassandraRepo;
	}

	public Optional<Account> find(Integer no) {

		AccountCassandraTable.Key key = new AccountCassandraTable.Key(no);

		return accountCassandraRepo.findById(key).map(table -> {
			return new Account(table.getKey().getNo(), table.getBalance());
		});

	}

}
