package me.dwarrowdelf.http.infrastructure.repository.cassandra;

import me.dwarrowdelf.http.infrastructure.repository.cassandra.AccountCassandraTable;
import org.springframework.data.cassandra.repository.CassandraRepository;
import org.springframework.data.cassandra.repository.Query;

public interface AccountCassandraRepo extends CassandraRepository<AccountCassandraTable, AccountCassandraTable.Key> {

	@Query("truncate table accounts")
	void truncate();

}
