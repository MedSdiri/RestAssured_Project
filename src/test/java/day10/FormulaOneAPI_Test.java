package day10;

import io.restassured.path.xml.XmlPath;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.List;

import static io.restassured.RestAssured.*;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;
import static org.junit.jupiter.api.Assertions.assertAll;

public class FormulaOneAPI_Test {

    @BeforeAll
    public static void init() {
        baseURI = "http://ergast.com";
        basePath = "/api/f1/";
    }


    @DisplayName("Test GET /drivers/{driver_id}")
    @Test
    public void testDriverOne() {

        XmlPath xp =
                given()
                        .pathParam("driver_id", "raikkonen")
                        .when()
                        .get("/drivers/{driver_id}")
                        .xmlPath();
        String givenName = xp.getString("MRData.DriverTable.Driver.GivenName");
        String familyName = xp.getString("MRData.DriverTable.Driver.FamilyName");
        System.out.println("givenName = " + givenName);
        System.out.println("familyName = " + familyName);


    }

    @DisplayName("Test GET /drivers")
    @Test
    public void testAllDrivers(){
        XmlPath xp = get("/drivers").xmlPath() ;
        // get first given name
        String firstGivenName = xp.getString("MRData.DriverTable.Driver[0].GivenName");
        System.out.println("firstGivenName = " + firstGivenName);
//        String firstGivenName = xp.get()
        // get third nationality
        String thirdNationality = xp.getString("MRData.DriverTable.Driver[2].Nationality");
        System.out.println("thirdNationality = " + thirdNationality);
        // get all last names
        List<String> allNames = xp.getList("MRData.DriverTable.Driver.GivenName", String.class);
        System.out.println("allNames = " + allNames);




    }

    // getting attributes out of xml element
    @DisplayName("Test GET /drivers/{driver_id} get attributes ")
    @Test
    public void testDriverOneAttribute() {
        // send request to get information of driver_id alonso and save  xml result and assert or assert in the chain
        XmlPath xp = given()
                .pathParam("driver_id", "alonso").
                        when()
                .get("/drivers/{driver_id}")
                .xmlPath();
    }



    @AfterAll
    public static void cleanup() {
        reset();
    }
}









































/*
body("MRData.DriverTable.Driver.find { it.@driverId == 'abate'}.FamilyName", is(equalTo("Abate")))
 */




/*
@ParameterizedTest(name = "{index} ==> testing name {0}")
@ValueSource(strings = {"alonso", "senna"})
@DisplayName("Test Get /drivers/{driver_name}")
public void testDriverOne(String name) {
  XmlPath xp =
          given()
          .pathParam("driver_name", name).
          when()
          .get("/drivers/{driver_name}")
          .xmlPath();
  String givenName = xp.getString("MRData.DriverTable.GivenName");
  System.out.println("givenName = " + givenName);
  String familyName = xp.getString("MRData.DriverTable.FamilyName");
  System.out.println("familyName = " + familyName);
}
 */