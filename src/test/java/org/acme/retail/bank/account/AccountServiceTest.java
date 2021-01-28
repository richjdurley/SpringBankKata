package org.acme.retail.bank.account;

import org.hamcrest.Matchers;
import org.junit.Assert;
import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

public class AccountServiceTest {

    @Test
    public void should_create_account() {
        Map<String, String> repository = new HashMap<>();
        AccountService service = new AccountService(repository);
        AccountRequest request = new AccountRequest("1234");
        Assert.assertThat(service.register(request), Matchers.any(String.class));
    }
}
