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

import java.util.Map;

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

        long phoneNum = jp.getLong("phone");
        System.out.println("phoneNum = " + phoneNum);

        System.out.println("jp.getMap(\"\") = " + jp.getMap(""));

        Map<String, Object> resultJsonMap = jp.getMap("");

        System.out.println("resultJsonMap = " + resultJsonMap);

    }

    @DisplayName("Extract data from GET /spartans")
    @Test
    public void testGetAllSpartans(){
       // Response response = get("/spartans");
       // response.prettyPrint();

        JsonPath jp = get("/spartans").jsonPath();

        System.out.println("jp.getInt(\"id[0]\") = " + jp.getInt("id[0]"));
        System.out.println("jp.getString(\"name[1]\") = " + jp.getString("name[1]"));

        //System.out.println("jp.getString(\"[0]\") = " + jp.getString("[0]"));
        System.out.println("jp.getMap(\"[0]\") = " + jp.getMap("[0]"));

        System.out.println("jp.getInt(\"[0].id\") = " + jp.getInt("[0].id"));
    }

    @DisplayName("Extract data from GET /spartans/search ")
    @Test
    public void testGetSearchSpartans(){
    //http://18.235.32.166:8000/api/spartans/search
        // ?nameContains=Abigale&gender=Male

        JsonPath jp =
                given()
                .queryParam("nameContains", "Abigale")
                .queryParam("gender", "Male")
                .log()
                .all()
        .when()
        .get("/spartans/search")
        .jsonPath()
        ;

        System.out.println("jp.getInt(\"content[0].id\") = " + jp.getInt("content[0].id"));

        System.out.println("jp.getString(\"content[1].name\") = " + jp.getString("content[1].name"));

        //Store first json object into a map
        Map<String, Object> firstResultMap = jp.getMap("content[0]");

        System.out.println("firstResultMap = " + firstResultMap);


    }

    @DisplayName("Saving json array fields into List")
    @Test
    public void testSavingJsonArrayFieldsIntoList(){
        JsonPath jp =
                given()
                        .queryParam("nameContains","Abigale")
                        .queryParam("gender","Male")
                        .log().all().
                        when()
                        .get("/spartans/search")
                        .prettyPeek()
                        .jsonPath();
    }


}
