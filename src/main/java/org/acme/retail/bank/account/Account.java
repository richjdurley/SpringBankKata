package org.acme.retail.bank.account;

import java.util.UUID;

public class Account {

    private UUID aaccountId;

    public UUID getAaccountId() {
        return aaccountId;
    }

    public void setAaccountId(UUID aaccountId) {
        this.aaccountId = aaccountId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Account account = (Account) o;

        return aaccountId != null ? aaccountId.equals(account.aaccountId) : account.aaccountId == null;
    }

    @Override
    public int hashCode() {
        return aaccountId != null ? aaccountId.hashCode() : 0;
    }
}
