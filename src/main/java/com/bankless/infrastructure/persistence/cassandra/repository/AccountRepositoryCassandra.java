package com.bankless.infrastructure.persistence.cassandra.repository;

import com.bankless.domain.model.Account;
import com.bankless.domain.repository.AccountRepository;
import com.bankless.infrastructure.persistence.cassandra.table.AccountTable;
import org.springframework.data.cassandra.repository.AllowFiltering;
import org.springframework.data.cassandra.repository.CassandraRepository;
import org.springframework.data.cassandra.repository.Query;

import java.util.List;
import java.util.Optional;

public interface AccountRepositoryCassandra extends CassandraRepository<AccountTable, AccountTable.Key> {

	@AllowFiltering
	List<Account> findByKey(String countryCode, long accountNo);

	@Query("truncate table " + AccountTable.ACCOUNTS_TABLE)
	void truncate();

}
