package day3;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import test_util.SpartanNoAuthBaseTest;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.junit.jupiter.api.*;
import test_util.SpartanNoAuthBaseTest;

import java.io.File;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import static org.hamcrest.MatcherAssert.assertThat;
import static io.restassured.RestAssured.* ;
import static org.hamcrest.Matchers.* ;
@DisplayName("Testing adding data to Spartan app multiple way")
public class SpartanPostingData_Test extends SpartanNoAuthBaseTest{

    @DisplayName("POST /spartans with String")
    @Test
    public void testPostDataWithStringBody(){
        /*
        {
        "name" : "Shannon"
        "gander" : "Female"
        "phone" : 1800233232
        }
         */

        String postStrBody = "{\n" +
                "                \"name\" : \"Shannon\",\n" +
                "                \"gender\" : \"Female\",\n" +
                "                \"phone\" : 1800233232\n" +
                "            }" ;
        given()
                .log()
                .all()
        //      .contentType("application/json")
                .contentType(ContentType.JSON)
                .body(postStrBody)
                .when()
                .post("/spartans")
                .then()
                .log()
                .all()
                .statusCode(201)
        .contentType(ContentType.JSON)
        .body("success", is("A Spartan is Born!"))
        .body("data.name", is("Shannon"))
                ;




    }

    @DisplayName("POST /spartans with external file")
    @Test
    public void testPostDataWithJsonFileAsBody() {

        File jsonFile = new File("singleSpartan.json");

        given()
                .log()
                .all()
                .contentType(ContentType.JSON)
                .body(jsonFile)
                .when()
                .post("/spartans")
                .then()
                .log()
                .all()
                .statusCode(201)
                ;


    }


    @DisplayName("POST /spartans with Map Object")
    @Test
    public void testPostDataWithMapObjectBody() {

        Map<String, Object> bodyMap = new LinkedHashMap<>();
        bodyMap.put("name", "Shannon");
        bodyMap.put("gender", "Female");
        bodyMap.put("phone", 1800233232L);

        given()
                .log()
                .all()
                .contentType(ContentType.JSON)
                .body(bodyMap)
                .when()
                .post("/spartans")
                .then()
                .log()
                .all()
                .statusCode(201)
                ;



    }


    }