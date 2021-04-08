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

//http://ergast.com/api/f1/driverStandings/1/drivers.json
public class FormulaOneAPI_Test {


    @BeforeAll
    public static void init(){
        baseURI = "http://ergast.com";
        basePath = "api/f1";
    }

    @DisplayName("GET /drivers.json and save result to pojo")
    @Test
    public void testDrivers(){



    }






    @AfterAll
    public static void tearDown(){
        reset();
    }
}
