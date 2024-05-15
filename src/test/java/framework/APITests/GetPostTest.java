package framework.APITests;
import io.restassured.RestAssured;
import org.hamcrest.Matchers;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import commonUtils.ReusableUtils;

import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.greaterThan;

public class GetPostTest  {

    @BeforeAll
    static void setUp(){

        RestAssured.baseURI = ReusableUtils.getProperty("Properties/api_config.properties","baseurl");
        System.out.println("Setup completed with Base url");
    }

    @Test
    void validateHeaderValue(){

        RestAssured.given().get().then().assertThat().statusCode(200).header("X-Ratelimit-Limit", equalTo("60"))
                .header("X-Ratelimit-Limit", Integer::parseInt, equalTo(60));

        System.out.println("Completed Test to Validate Header - X-Ratelimit-Limit");
    }

    @Test
    void validateMultipleHeaders(){

        RestAssured.get("/rate_limit").then().header("X-Ratelimit-Limit", response -> greaterThan(response.header("X-Ratelimit-Remaining")));

    }

    @ParameterizedTest
    @CsvSource({
            "X-Ratelimit-Limit,60",
            "Content-Type,application/json; charset=utf-8,",
            "Server,GitHub.com",
            "X-Frame-Options,deny"

    })
    void parameterizedTestForHeaders(String header,String expectedValue){

        String headerKey = RestAssured.given().get().header(header);

        Assertions.assertEquals(headerKey,expectedValue);

    }

    @Test
    void postWithoutAuthorizationFails(){

        RestAssured.given().post("/user/repos").then().assertThat().statusCode(401);
    }

    @Test
    void bodyContainsCurrentURL(){

        RestAssured.given().get("/users/andrejs-ps").then().
                body("url",response -> Matchers.endsWith(response.body().jsonPath().get("login")));

    }
}
