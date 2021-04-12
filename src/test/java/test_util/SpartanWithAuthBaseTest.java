package test_util;
import io.restassured.RestAssured;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;

public abstract class SpartanWithAuthBaseTest {

    @BeforeAll
    public static void init(){

        RestAssured.baseURI = "http://54.92.150.105:7000" ;
        RestAssured.basePath = "/api" ;

    }

    @AfterAll
    public static void cleanup(){

        RestAssured.reset();

    }


}