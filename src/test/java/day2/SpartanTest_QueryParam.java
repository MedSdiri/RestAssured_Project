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

public class SpartanTest_QueryParam extends SpartanNoAuthBaseTest{

    @DisplayName("Test GET / spartans/ search Endpoint")
    @Test
    public void testSearch(){
        Response response =
                given()
                        .log()
                        .all()
                .queryParam("nameContains", "Terence")
                .queryParam("gender", "Male")
                .when()
                .get("/spartans/search")
                .prettyPeek()
                ;
    }

}
