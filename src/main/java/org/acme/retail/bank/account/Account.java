package org.acme.retail.bank.account;

import java.util.UUID;

public class Account {

    private UUID accountId;

    public UUID getAccountId() {
        return accountId;
    }

    public void setAccountId(UUID accountId) {
        this.accountId = accountId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Account account = (Account) o;

        return accountId != null ? accountId.equals(account.accountId) : account.accountId == null;
    }

    @Override
    public int hashCode() {
        return accountId != null ? accountId.hashCode() : 0;
    }
}
