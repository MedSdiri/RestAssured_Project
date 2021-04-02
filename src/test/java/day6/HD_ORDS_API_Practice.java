package day6;

import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.junit.jupiter.api.*;

import static org.hamcrest.MatcherAssert.*;
import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
public class HD_ORDS_API_Practice {
    //GET http://18.235.32.166:1000/ords/hr/api/regions
    // base_uri = http://18.235.32.166:1000
    // base_path =  /ords/hr/api
    // resources /regions


    @BeforeAll
    public static void init(){
        baseURI = "http://54.92.150.105:1000";
        basePath = "/ords/hr/api" ;
    }
    @DisplayName("GET /regions test")
    @Test
    public void testAllRegions(){
        get("/regions").prettyPeek() ;
    }







    @AfterAll
    public static void cleanUp(){
        reset();
    }
}
