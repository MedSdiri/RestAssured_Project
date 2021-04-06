package day7;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import pojo.SpartanPojo;
import test_util.SpartanNoAuthBaseTest;
import static io.restassured.RestAssured.*;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;

import io.restassured.response.Response;

public class SpartanDeserialization_Test extends SpartanNoAuthBaseTest {

    // Serialization    : Java Object to Json (or any other type of text)
    // De-Serialization : Json(text) to Java

    @DisplayName("GET /spartans/{id}")
    @Test
    public void testGetOneData(){

        given()
                .pathParam("id", 100)
                .when()
                .get("/spartans/{id}")
                .then()
                .statusCode(200)
                .log().body()
                ;

        Response response =
                given()
                .pathParam("id", 100)
                .when()
                .get("/spartans/{id}");

        SpartanPojo sp = response.as(SpartanPojo.class);

        System.out.println("sp = " + sp);


    }


}