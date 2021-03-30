package day4;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import spartan_util.SpartanUtil;
import test_util.SpartanNoAuthBaseTest;
import test_util.SpartanNoAuthBaseTest;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.junit.jupiter.api.*;
import test_util.SpartanNoAuthBaseTest;

import static org.hamcrest.MatcherAssert.*;
import static io.restassured.RestAssured.* ;
import static org.hamcrest.Matchers.* ;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import test_util.SpartanNoAuthBaseTest;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
public class SpartanRandomPOST_Test extends SpartanNoAuthBaseTest {

    @DisplayName("/POST /spartans with random Data")
    @Test
    public void addOneSpartanTest(){

        Map<String, Object> payLoad = SpartanUtil.getRandomSpartanMap();

        given()
                .log().body()
                .contentType(ContentType.JSON)
                .body(payLoad)
                .when()
                .post("/spartans")
                .then()
                .log().all()
                .statusCode(is(201))
        .body("data.name", is(payLoad.get("name")))
        .body("data.gender", equalTo(payLoad.get("gender")))
        .body("data.phone", is(payLoad.get("phone")))
                ;

    }

}
