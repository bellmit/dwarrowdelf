package com.bankless.domain.repository;

import com.bankless.domain.model.Account;
import java.util.Optional;

public interface AccountRepository {

	public Optional<Account> find(String countryCode, int no);

}
