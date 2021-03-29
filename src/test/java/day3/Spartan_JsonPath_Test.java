package day3;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
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
public class Spartan_JsonPath_Test extends SpartanNoAuthBaseTest{

    @Test
    public void testOne(){

        Response respose =
                given()
                        .log().all()
                .pathParam("id","100")
                .when()
                .get("/spartans/{id}")
                .prettyPeek();

        int myId = respose.path("id");
        System.out.println("myId = " + myId);

        JsonPath jp = respose.jsonPath();
        myId = jp.getInt("id");
        System.out.println("myId = " + myId);

    }


}
