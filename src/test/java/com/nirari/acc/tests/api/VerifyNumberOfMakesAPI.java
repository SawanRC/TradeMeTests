package com.nirari.acc.tests.api;

import com.nirari.acc.base.BaseTest;

import static io.restassured.RestAssured.*;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;

import io.restassured.response.Response;
import org.testng.annotations.Test;


public class VerifyNumberOfMakesAPI extends BaseTest {

    @Test
    public void verifyNumberOfMakesAPI() {

        when("Query the UsedCars endpoint of the TradeMe API");
            Response res = get("https://api.trademe.co.nz/v1/Categories/UsedCars.json?with_counts=true");

        then("Assert that the status code returned was 200 (OK)");
            assertThat(res.getStatusCode(), equalTo(200));

        and("Assert that the amount of cars returned equals 78");
            assertThat(res.body().jsonPath().getList("Subcategories").size(), equalTo(78));
    }
}
