package day7;

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

public class BreakingBad_POJO_Test {

    @BeforeAll
    public static void init(){
        baseURI = "https://www.breakingbadapi.com";
        basePath = "/api";
    }

    @AfterAll
    public static void cleanup(){
        reset();
    }

    @DisplayName("GET /characters")
    @Test
    public void testDeserialization(){


    }



}
