package practice;

import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import pojo.Spartan;
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

public class PracticeSpartanApi extends SpartanNoAuthBaseTest {

    @Test
    public void testGetALlSPartans(){
        JsonPath jp =
                given()
                .log()
                .all()
                .contentType(ContentType.JSON)
                .when()
                .get("/spartans")
                        .jsonPath()
                ;

        List<Integer> listOfIds = jp.getList("id", Integer.class);
        List<String> listOfNames = jp.getList("name", String.class);
        List<Long> listOfPhones = jp.getList("phone", Long.class);

        //System.out.println("listOfIds = " + listOfIds);
        //System.out.println("listOfNames = " + listOfNames);
        //System.out.println("listOfPhones = " + listOfPhones);
        assertThat(listOfNames, hasSize(listOfNames.size()));


    }

    @Test
    public void getOneSPartan(){
       Response response = given()
                .contentType(ContentType.JSON)
                .log()
                .ifValidationFails()
                .pathParam("id", 100)
                .when()
                .get("/spartans/{id}")

                ;
        System.out.println("response.path(\"id\") = " + response.path("id"));
        assertThat(response.statusCode(), is(200));

    }
    @Test
    public void postOneSPartan(){
        Spartan spartan = new Spartan("Mark","Male", 1233654798l);
        File fileJson = new File("singleSpartan.json");

        given()
                .log()
                .all()
                .contentType(ContentType.JSON)
                .body(spartan)
                .when()
                .post("/spartans")
                .then()
                .log()
                .all()
                .statusCode(201)
                ;
        given()
                .log()
                .all()
                .contentType(ContentType.JSON)
                .body(fileJson)
                .when()
                .post("/spartans")
                .then()
                .log()
                .all()
                .statusCode(201)
                ;


    }

    @Test
    public void updateSpartan(){
        File fileJson = new File("singleSpartan.json");

        given()
                .log()
                .all()
                .pathParam("id", 213)
                .contentType(ContentType.JSON)
                .body(fileJson)
                .when()
                .put("/spartans/{id}")
                .then()
             //   .log()
               // .all()
                .statusCode(204)
                ;
        JsonPath jp =given()
                .pathParam("id", 213)
                .when()
                .get("/spartans/{id}")
                .prettyPeek()
                .jsonPath()
                ;
        System.out.println("jp.getString(\"name\") = " + jp.getString("name"));
        Map<String, Object> putMap = new LinkedHashMap<>();
        putMap.put("name", "Jackson");
        putMap.put("gender", "Male");
        putMap.put("phone", 180044809271l);
        given()
                .log()
                .ifValidationFails()
                .contentType(ContentType.JSON)
                .pathParam("id", 213)
                .body(putMap)
                .when()
                .put("/spartans/{id}")
                .then()
        .statusCode(204)

                ;
        JsonPath jp2 =
                given()
                .pathParam("id", 213)
                .when()
                .get("/spartans/{id}")
                .jsonPath()
                ;
        System.out.println("jp2.getInt(\"id\") = " + jp2.getInt("id"));
        System.out.println("jp2.getString(\"name\") = " + jp2.getString("name"));


    }

}
