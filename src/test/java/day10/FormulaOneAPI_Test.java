package day10;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

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


    }





    @AfterAll
    public static void cleanup(){
        reset();
    }
}
