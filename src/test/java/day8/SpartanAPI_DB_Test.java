package day8;
import org.junit.jupiter.api.*;
import pojo.*;
import pojo.Character;
import test_util.HR_ORDS_API_BaseTest;
import io.restassured.path.json.JsonPath;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import test_util.SpartanNoAuthBaseTest;
import static io.restassured.RestAssured.*;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;
import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import test_util.ConfigurationReader;
import test_util.DB_Utility;
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




}
