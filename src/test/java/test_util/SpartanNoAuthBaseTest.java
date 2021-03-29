package test_util;

import io.restassured.RestAssured;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;

public abstract class SpartanNoAuthBaseTest {
    //18.235.32.166:8000 akbars ip
    //"http://54.92.150.105:8000" my ip

    @BeforeAll
    public static void init(){
        // as a homework , put these information
        // in configurations.properties file
        // this will set the part of URL at RestAssured
        RestAssured.baseURI     = "http://54.92.150.105:8000";
//        RestAssured.port = 8000 ;
        RestAssured.basePath    = "/api" ;
    }

    @AfterAll
    public static void cleanup(){
        RestAssured.reset();
    }


}