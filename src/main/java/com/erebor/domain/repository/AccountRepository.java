package com.erebor.domain.repository;

import com.erebor.domain.model.Account;
import java.util.Optional;

public interface AccountRepository {

	public Optional<Account> find(String countryCode, int no);

}
