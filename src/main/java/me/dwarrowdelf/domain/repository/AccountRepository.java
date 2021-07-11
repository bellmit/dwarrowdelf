package me.dwarrowdelf.domain.repository;

import me.dwarrowdelf.domain.model.Account;
import java.util.Optional;

public interface AccountRepository {

	public Optional<Account> find(String countryCode, int no);

}
