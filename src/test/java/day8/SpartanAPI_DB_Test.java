package day8;
import org.junit.jupiter.api.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.ValueSource;
import pojo.*;
import pojo.Character;
import test_util.*;
import io.restassured.path.json.JsonPath;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.*;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;
import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static test_util.DB_Utility.*;
import test_util.SpartanNoAuthBaseTest;

import javax.swing.text.Style;
import java.util.Map;

public class SpartanAPI_DB_Test extends SpartanNoAuthBaseTest {

    @Test
    public void testDB_Connection(){

        //DB_Utility.runQuery("select * from spartans");
        //DB_Utility.displayAllData();

    }

    @DisplayName("Test GET /spartans{id} match DB Data")
    @Test
    public void testGetSingleSpartanAndMatchWithDB(){
        int spartanId = 100;

        DB_Utility.runQuery("Select * from spartans where spartan_id = "+spartanId);
        //DB_Utility.displayAllData();
        Map<String, String> firstRowMap = DB_Utility.getRowMap(1);
        System.out.println("firstRowMap = " + firstRowMap);

        given()
                .pathParam("id", spartanId)
                .log().uri()
        .when()
        .get("/spartans/{id}")
        .then()
        .log().all()
        .statusCode(200)
        .body("id", is(spartanId))
        .body("name", is(firstRowMap.get("NAME")))
        .body("gender", is(firstRowMap.get("GENDER")))
        .body("phone.toLong()", is(Long.parseLong(firstRowMap.get("PHONE"))))
        ;

    }

    @DisplayName("Test GET /spartans{id} match DB Data with POJO")
    @Test
    public void testGetSingleSpartanAndMatchWithDB_Pojo() {
        int spartanId = 100;

        DB_Utility.runQuery("Select * from spartans where spartan_id = " + spartanId);
        //DB_Utility.displayAllData();
        Map<String, String> firstRowMap = DB_Utility.getRowMap(1);
        System.out.println("firstRowMap = " + firstRowMap);

        SpartanPojo actualResulat =
                given()
                        .pathParam("id", spartanId)
                        .log().uri()
                        .when()
                        .get("/spartans/{id}")
                .as(SpartanPojo.class);
        System.out.println("actualResulat = " + actualResulat);

        assertThat(actualResulat.getId(), is(spartanId));
        assertThat(actualResulat.getName(), is(firstRowMap.get("NAME")));
        assertThat(actualResulat.getGender(), is(firstRowMap.get("GENDER")));
        assertThat(actualResulat.getPhone(), is(Long.parseLong(firstRowMap.get("PHONE"))));



    }
    @DisplayName("Test GET /spartans{id} match DB Data with POJO stable")
    @Test
    public void testGetSingleSpartanAndMatchWithDB_Pojo2() {

        DB_Utility.runQuery("Select * from spartans");
        Map<String, String> expectedResultMap = DB_Utility.getRowMap(1);
        //DB_Utility.displayAllData();
        int spartanId = Integer.parseInt(expectedResultMap.get("SPARTAN_ID"));

        Map<String, String> firstRowMap = DB_Utility.getRowMap(1);
        System.out.println("firstRowMap = " + firstRowMap);

        SpartanPojo actualResulat =
                given()
                        .pathParam("id", spartanId)
                        .log().uri()
                        .when()
                        .get("/spartans/{id}")
                        .as(SpartanPojo.class);
        System.out.println("actualResulat = " + actualResulat);

        assertThat(actualResulat.getId(), is(spartanId));
        assertThat(actualResulat.getName(), is(firstRowMap.get("NAME")));
        assertThat(actualResulat.getGender(), is(firstRowMap.get("GENDER")));
        assertThat(actualResulat.getPhone(), is(Long.parseLong(firstRowMap.get("PHONE"))));

    }

    @DisplayName("Spartan Home work GET /spartans/search")
    @Test
    public void spartanHomeWork(){

       List<SpartanPojo> apiResult =
        given()
                .queryParam("nameContains", "a")
                .queryParam("gender", "Female")
                .when()
                .get("/spartans/search")
                .jsonPath()
                .getList("content", SpartanPojo.class)
        ;

        runQuery("SELECT * FROM SPARTANS WHERE LOWER(NAME) LIKE '%a%' and GENDER = 'Female'");
        List<Map<String, String>> dbResult = getAllRowAsListOfMap();

        assertThat(apiResult.size(), is(dbResult.size()));


        for (SpartanPojo spartan: apiResult) {
            assertThat(spartan.getName().toLowerCase().contains("a"), is(true) );
            assertThat(spartan.getGender(), is("Female"));

        }



    }

    @ParameterizedTest
    @MethodSource("byPassGetSpartansAPI")
    public void spartanHomeWorkMethodParam(SpartanPojo spartan){







    }






    public static List<Map<String, String>> getSpartansDB(String name, String gender){

        String query = "SELECT * FROM SPARTANS WHERE LOWER(NAME) LIKE '%"+name+"%' and GENDER = '"+gender+"'";

        runQuery(query);
        List<Map<String, String>> dbResult = getAllRowAsListOfMap();
        return dbResult;
    }

    public static List<SpartanPojo> byPassGetSpartansAPI(){
      return getSpartansAPI("a", "Female") ;
    }
    public static List<Map<String, String>> byPassGetSpartansDB(){
        return getSpartansDB("a", "Female") ;
    }

    public static List<SpartanPojo> getSpartansAPI(String name, String gender){
        List<SpartanPojo> apiResult =
                given()
                        .queryParam("nameContains", name)
                        .queryParam("gender", gender)
                        .when()
                        .get("/spartans/search")
                        .jsonPath()
                        .getList("content", SpartanPojo.class)
                ;
        return apiResult;
    }



    /** TODO :
     // AS HOMEWORK  GET /spartans/search
     // search for nameContains a and Female
     // compare DB Result total count with API Result total count
     // SELECT * FROM SPARTANS WHERE LOWER(NAME) LIKE '%a%' and GENDER = 'Female'
     // Make sure all your data in json array match exact criteria above (nameContains a and Female
     // Optionally , Write a parametrized Test with multiple different search criteria
     */



}
