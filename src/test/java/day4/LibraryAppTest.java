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
        .body("token", is(not(blankOrNullString())))
                ;



    }

    @DisplayName("test the token")
    @Test
    public void testGetTokenDecodeToken(){
        // first send request to POST /login extract token
        // then send request to POST /decode to verify emails and other info
        String username = "librarian69@library" ;
        String password =  "KNPXrm3S";
        String myToken =
                given()
                .log().all()
                .contentType(ContentType.URLENC)
                .formParam("email", username)
                .formParam("password", password)
                .when()
                .post("/login")
                .then()
                .log().all()
                .statusCode(200)
                .extract()
                .path("token")
                ;
        given()
                .log().all()
                .contentType(ContentType.URLENC)
                .formParam("token", myToken)
                .when()
                .post("/decode")
                .then()
                .log().all()
                .statusCode(200)
                .body("email", is(username))
                ;



    }
}
