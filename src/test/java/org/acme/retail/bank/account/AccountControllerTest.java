package org.acme.retail.bank.account;

import com.jayway.restassured.RestAssured;
import com.jayway.restassured.parsing.Parser;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;

@SpringBootTest(classes = AccountApplication.class, webEnvironment = SpringBootTest.WebEnvironment.DEFINED_PORT)
@RunWith(SpringRunner.class)
@ActiveProfiles("accountAPITestProfile")
public class AccountControllerTest {

    @Before
    public void setup() {
        RestAssured.port=8080;
        RestAssured.baseURI="http://localhost";
        RestAssured.defaultParser = Parser.JSON;
    }

    @Test
    public void exampleTest() {
        //given().when().contentType("application/json").header("Authorization-X", "customer-auth-token=" + customerAuthToken).body(accountRegistrationRequest).post("/account/register").then()
        //        .statusCode(SC_OK)
        //        .body("accountId", is(accountIdToReturn.getAccountId()));
    }


}
