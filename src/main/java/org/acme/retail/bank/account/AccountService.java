package org.acme.retail.bank.account;

import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

@Service
public class AccountService {

    private final Map<String, String> customerAccountRepository;

    public AccountService(Map<String, String> customerAccountRepository) {
        this.customerAccountRepository = customerAccountRepository;
    }

    AccountService() {
        customerAccountRepository = new HashMap<>();
    }

    /**
     * The service accepts a valid account request, and puts the new accountId in the repository
     *
     * @param request
     * @return
     */
    public String register(AccountRequest request) {
        String newAccountId = UUID.randomUUID().toString();
        customerAccountRepository.put(request.getCustomerId(), newAccountId);
        return customerAccountRepository.get(request.getCustomerId());
    }
}
