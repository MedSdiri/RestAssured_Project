package day2;
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

public class BreakingBad_Test {
    @BeforeAll
    public static void init(){
        baseURI = "https://www.breakingbadapi.com";
        basePath = "/api";

    }
    @AfterAll
    public static void cleanUp(){
        reset();
    }

    @Test
    public void testFilterCharacterName(){
        given()
                .log()
                .uri()
                .queryParam("name", "Walter")
                .when()
                .get("/characters")

                .then()
                   .log()
                   .all()
                   .statusCode(200)
                   .contentType("application/json; charset=utf-8")
                ;

    }

    @DisplayName("Test Get /characters/{char_id}")
    @Test
    public void test1Character(){

        given()
                .pathParam("char_id" , 1 )
                .log().uri().
                when()
                .get("/characters/{char_id}").
                then()
                .log().all()
                .statusCode(200)
                .header("Content-Type","application/json; charset=utf-8")
                .contentType("application/json; charset=utf-8")
        ;
    }

    @DisplayName("Test Get /episodes/{episode_id}")
    @Test
    public void test1Episode(){

        given()
                .pathParam("episode" , 60 )
                .log().uri().
                when()
                .get("/episodes/{episode}").
                then()
                .log().all()
                .statusCode(200)
                .header("Content-Type","application/json; charset=utf-8")
                .contentType("application/json; charset=utf-8")
        ;
    }



}
