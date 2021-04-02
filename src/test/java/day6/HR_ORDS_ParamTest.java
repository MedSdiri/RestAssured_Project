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
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.ValueSource;
import test_util.HR_ORDS_API_BaseTest;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
public class HR_ORDS_ParamTest extends HR_ORDS_API_BaseTest{
    //GET http://54.92.150.105:1000/ords/hr/api/regions
    // base_uri = http://18.235.32.166:1000
    // base_path =  /ords/hr/api
    // resources /countries/{country_id}

    @Test
    public void testCountries(){
        //get ("countries").prettypeek();
        get("/countries/AR").prettyPeek();
    }

    @ParameterizedTest
    @ValueSource(strings = {"AR", "AU" ,"US"}     )
    public void testSingleCountryWithValues( String countryIdArg ){
        // GET /countries/{country_id}

        given()
                .log().uri()
                .pathParam("country_id", countryIdArg)
                .when()
                .get("/countries/{country_id}")
                .then()
                .log().body()
                .statusCode(200)
                .body("count", is(1))
                ;
    }

    @ParameterizedTest
    @CsvSource({
            "AR, Argentina",
            "US, United States of America",
            "UK, United Kingdom"
    })
    public void testSingleCountryWithCSVSource(String countryIdArg, String countryNameArg){

        given()
                .log()
                .uri()
                .pathParam("country_id", countryIdArg)
                .when()
                .get("/countries/{country_id")
                .then()
                .body("items[0].country_name", is(countryIdArg))
                ;
    }

    @ParameterizedTest
    @MethodSource("getManyCountries")
    public void testCountryWithMethodSource(String countryIdArg){
        System.out.println("countryIdArg = " + countryIdArg);
        System.out.println("countryIdArg = " + countryIdArg);
        // GET /countries/{country_id}
        given()
                .log().uri()
                .pathParam("country_id", countryIdArg).
                when()
                .get("/countries/{country_id}").
                then()
                .log().body()
                .statusCode(200)
                .body("count", is(1) )
        ;
    }

    public static List<String> getManyCountries(){
       // List<String> coountryNameList = Arrays.asList("AR", "BE", "US");
        List<String> countryNameList =
                get("/countries")
                .jsonPath()
                .getList("items.country_id", String.class)
                ;


        return countryNameList;
    }

}
