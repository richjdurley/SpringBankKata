package org.acme.retail.bank.account;

public interface IdentityService {
    boolean verifyToken(String token);
}
