package com.bankless.domain.repository;

import com.bankless.domain.model.Account;
import java.util.Optional;

public interface AccountRepository {

	Optional<Account> find(String countryCode, long no);

}
