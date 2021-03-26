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

@DisplayName("Spartan Test with a Path variable")
public class SpartanTest_PathVariable extends SpartanNoAuthBaseTest {

    @Test
    public void getOneSpartan() {
        //get("/spartans/100").prettyPrint();

        // Iwant to provide 100 as path variable|parameter
        // I want to provide accept header
        Response r1 =
                given()
                        .header("Accept", "application/json")
                        .pathParam("spartan_id", "100")
                        .when()
                        .get("/spartans/{spartan_id}")
                        .prettyPeek();
        ;

        Response r2 =
                given()
                        .accept("application/json")
                        .when()
                        .get("/spartans/{spartan_id}", 100)
                        .prettyPeek();

    }

    @DisplayName("Logging the request")
    @Test
    public void getOneSpartanWithLog() {
        Response response =
                given()
                        .log()
                        .all()
                        .accept("application/json")
                        .pathParam("id", "100")
                        .when()
                        .get("/spartans/{id}")
                        .prettyPeek();


        assertThat(response.statusCode() , equalTo(200) );
        assertThat(response.contentType() , is("application/json"));
        assertThat(response.path("name") , is("Wonder Woman")     );
    }





}
