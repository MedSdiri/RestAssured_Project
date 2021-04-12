package day10;
import io.restassured.path.xml.XmlPath;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static io.restassured.RestAssured.*;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;
import static org.junit.jupiter.api.Assertions.assertAll;
public class FormulaOneAPI_Test {

    @BeforeAll
    public static void init(){
        baseURI = "http://ergast.com";
        basePath = "/api/f1/";
    }


    @DisplayName("Test GET /drivers/{driver_id}")
    @Test
    public void testDriverOne(){

        XmlPath xp =
                given()
                .pathParam("driver_id", "raikkonen")
                .when()
                .get("/drivers/{driver_id}")
                .xmlPath()
                ;
        String givenName = xp.getString("MRData.DriverTable.Driver.GivenName");
        String familyName = xp.getString("MRData.DriverTable.Driver.FamilyName");
        System.out.println("givenName = " + givenName);
        System.out.println("familyName = " + familyName);


    }






    @AfterAll
    public static void cleanup(){
        reset();
    }
}
