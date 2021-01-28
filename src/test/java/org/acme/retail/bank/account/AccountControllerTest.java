package org.acme.retail.bank.account;

import com.jayway.restassured.RestAssured;
import com.jayway.restassured.parsing.Parser;
import org.hamcrest.Matchers;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpStatus;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;

@SpringBootTest(classes = AccountApplication.class, webEnvironment = SpringBootTest.WebEnvironment.DEFINED_PORT)
@RunWith(SpringRunner.class)
@ActiveProfiles("accountAPITestProfile")
public class AccountControllerTest {

    public static final String INVALID_TOKEN = "invalid_token";
    public static final String VALID_CUSTOMER_ID = "valid_customer_id";
    public static final String VALID_ACCOUNT_ID = "VALID_ACCOUNT_ID";
    private static final String VALID_TOKEN = "valid_token";
    @Autowired
    IdentityService identityService;

    @Autowired
    AccountService accountService;

    @Before
    public void setup() {
        RestAssured.port = 8080;
        RestAssured.baseURI = "http://localhost";
        RestAssured.defaultParser = Parser.JSON;
    }

    @Test
    public void should_fail_on_invalid_customer_auth_token() {

        Mockito.when(identityService.verifyToken(INVALID_TOKEN)).thenReturn(false);

        Account account = new Account();

        RestAssured.given().given().when()
                .contentType("application/json")
                .header("Authorization-X", "customer-auth-token=" + INVALID_TOKEN)
                .body(account)
                .post("/account/register")
                .then()
                .statusCode(HttpStatus.UNAUTHORIZED.value());
    }

    @Test
    public void should_accept_valid_customer_for_registration() {
        AccountRequest request = new AccountRequest(VALID_CUSTOMER_ID);

        Mockito.when(identityService.verifyToken(Mockito.any())).thenReturn(true);
        Mockito.when(accountService.register(request)).thenReturn(VALID_ACCOUNT_ID);

        RestAssured.given().given().when()
                .contentType("application/json")
                .header("Authorization-X", "customer-auth-token=" + VALID_TOKEN)
                .body(request)
                .post("/account/register")
                .then()
                .statusCode(HttpStatus.OK.value()).body(Matchers.is(VALID_ACCOUNT_ID));
        Mockito.verify(identityService, Mockito.times(1)).verifyToken("customer-auth-token=" + VALID_TOKEN);
        Mockito.verify(accountService, Mockito.times(1)).register(request);
    }

}
