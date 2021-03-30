package day4;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.junit.jupiter.api.*;

import static org.hamcrest.MatcherAssert.*;
import static io.restassured.RestAssured.* ;
import static org.hamcrest.Matchers.* ;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
@DisplayName("Library App Simple Test")

public class LibraryAppTest {

    @BeforeAll
    public static void init(){
        baseURI ="http://library1.cybertekschool.com";
        basePath ="/rest/v1";
    }
    @AfterAll
    public static void cleanup(){
        reset();
    }

    @DisplayName("test POST /login")
    @Test
    public void testLogin(){
        // librarian69@library  , KNPXrm3S

        given()
                .log().all()
                .contentType(ContentType.URLENC)
                .formParam("email", "librarian69@library")
                .formParam("password", "KNPXrm3S")
        .when()
                .post("/login")
        .then()
                .statusCode(200)
                .log()
                .all()
                ;



    }
}
