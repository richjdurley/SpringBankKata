package org.acme.retail.bank.account;

public class AccountRequest {

    private String customerId;

    public AccountRequest() {
    }

    public AccountRequest(String customerId) {
        this.customerId = customerId;
    }

    public String getCustomerId() {
        return customerId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        AccountRequest that = (AccountRequest) o;

        return customerId != null ? customerId.equals(that.customerId) : that.customerId == null;
    }

    @Override
    public int hashCode() {
        return customerId != null ? customerId.hashCode() : 0;
    }
}
