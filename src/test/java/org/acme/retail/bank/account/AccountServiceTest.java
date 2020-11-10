package org.acme.retail.bank.account;

import org.hamcrest.Matchers;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.HashMap;
import java.util.Map;

public class AccountServiceTest {

    @Test
    public void shouldCreateAccount() {
        Map<String, String> repository = new HashMap<>();
        AccountService service = new AccountService(repository);
        AccountRequest request = new AccountRequest("1234");
        Assert.assertThat(service.register(request), Matchers.any(String.class));
    }
}
