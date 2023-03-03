package org.example;

import javafx.beans.binding.Bindings;
import org.junit.Test;

//import static io.restassured.matcher.RestAssuredMatchers.*;
import org.hamcrest.*;
//import static io.restassured.RestAssured.*;
import org.hamcrest.MatcherAssert;

import java.util.HashMap;

import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.equalTo;

public class firstRestAssure {
    /*
    public static void main(String[] args) {
        getResponseBody();
    }*/

    @Test
    public void getResponseBody() {
        given().when().get("http://demo.guru99.com/V4/sinkministatement.php?CUSTOMER_ID=68195&PASSWORD=1234!&Account_No=1")
                .then()
                .log()
                .all();
    }

    @Test
    public void requestUsZipCode90210_checkPlaceNameInResponseBody_expectBeverlyHills() {
        given().
                when().
                get("http://zippopotam.us/us/90210").
                then().
                assertThat().
                body("places[1].'place name'", equalTo("Beverly Hills"));
    }

    @Test
    public void pet_store() {
        given().
                when().
                get("https://petstore.swagger.io/v2/pet/900022").
                then().
                assertThat().
                body("id", equalTo(900021));
    }

    @Test
    public void petStoreNotFound() {
        given().
                when().
                get("https://petstore.swagger.io/v2/pet/900022").
                then().
                assertThat().
                body("message", equalTo("Pet not found"));
    }

    @Test
    public void givenMovie_whenMakingPostRequestToMovieEndpoint_thenCorrect() {
        Map<String, String> request = new HashMap<>();
        request.put("id", "11");
        request.put("name", "movie1");
        request.put("synopsis", "summary1");

        int movieId = given().contentType("application/json")
                .body(request)
                .when()
                .post(uri + "/movie")
                .then()
                .assertThat()
                .statusCode(HttpStatus.CREATED.value())
                .extract()
                .path("id");
        assertThat(movieId).isEqualTo(11);
    }
}
