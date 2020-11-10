package org.acme.retail.bank.account;

import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

@Service
public class AccountService {

    private final Map<String, String> repository;

    public AccountService(Map<String, String> repository) {
        this.repository = repository;
    }

    AccountService() {
        repository = new HashMap<>();
    }

    public String register(AccountRequest request) {
        repository.put(request.getCustomerId(), UUID.randomUUID().toString());
        return repository.get(request.getCustomerId());
    }
}
