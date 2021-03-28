package day2;

import io.restassured.http.ContentType;
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

@DisplayName("Spartan Content type Summary")
public class ContentType_Test extends SpartanNoAuthBaseTest {

    @DisplayName("GET /hello")
    @Test
    public void testHelloContentType(){
        when()
                .get("/hello")
                .then()
                .contentType(ContentType.TEXT)
                .body(is("Hello from Sparta"))
                ;
    }

    @DisplayName("GET /spartans in json")
    @Test
    public void testSpartansJsonContentType(){
        given()
                .accept(ContentType.JSON)
                .when()
                .get("/spartans")
                .then()
                .contentType(ContentType.JSON)
                ;
    }

    @DisplayName("GET /spartans in xml")
    @Test
    public void testSpartansXmlContentType(){
        given()
                .accept(ContentType.XML)
                .when()
                .get("/spartans")
                .then()
                .contentType(ContentType.XML)
        ;
    }
}
