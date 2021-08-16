package me.dwarrowdelf.http.domain.repository;

import me.dwarrowdelf.http.domain.model.Account;
import java.util.Optional;

public interface AccountRepository {

	public Optional<Account> find(Integer no);

}
