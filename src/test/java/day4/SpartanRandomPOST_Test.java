package day4;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import pojo.Spartan;
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
    public void addOneSpartanMAPTest(){

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

    @DisplayName("/POST /spartans with POJO")
    @Test
    public void addOneSpartanPOJOTest(){

        Spartan randomPOJO = SpartanUtil.getRandomSpartanPOJO();

        given()
                .log().body()
                .contentType(ContentType.JSON)
                .body(randomPOJO)
                .when()
                .post("/spartans")
                .then()
                .log().all()
                .statusCode(is(201))
                .body("data.name", is(randomPOJO.getName()))
                .body("data.gender", equalTo(randomPOJO.getGender()))
                .body("data.phone", is(randomPOJO.getPhone()))
        ;

    }

    @DisplayName("POST /spartans and send GET /spartans/{id} to verify")
    @Test
    public void testAddOneDataThenGetOneDataToVerify(){
        // send post request, same the if that got generated
        // check status code is 201
        // send get request using the id saved from post request
        // check status code is 200 and body match exactly what we sent
        Spartan randomPOJO = SpartanUtil.getRandomSpartanPOJO();

        Response response =
                given()
                .log().body()
                .contentType(ContentType.JSON)
                .body(randomPOJO)
                .when()
                .post("/spartans")
                .prettyPeek()
                ;
        int newId = response.path("data.id");
        System.out.println("newId = " + newId);
        //int newId = response.jsonPath().getInt("data.id");
        int statusCode = response.statusCode();
        assertThat(response.statusCode(), is(201));

        given()
                .log()
                .uri()
                .pathParam("id", newId)
                .when()
                .get("/spartans/{id}")
                .then()
                .log()
                .body()
                .statusCode(200)
        .body("id", is(newId))
        .body("name", is(randomPOJO.getName()))
        .body("gender", is(randomPOJO.getGender()))
        .body("phone", is(randomPOJO.getPhone()))
                ;


    }

}
