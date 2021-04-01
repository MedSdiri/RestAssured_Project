package day5;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static io.restassured.RestAssured.*;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.* ;


public class CsvSourceParameterizedTest {


    @ParameterizedTest
    @CsvSource({
            "1, 3 , 4",
            "2, 3 , 5",
            "8, 7 , 15",
            "10, 9 , 19"
    })
    public void testAddition(int num1 , int num2 , int expectedResult ){
        System.out.println("num1 = " + num1);
        System.out.println("num2 = " + num2);
        System.out.println("expectedResult = " + expectedResult);

        assertThat(num1+num2, equalTo(expectedResult));
    }

    @ParameterizedTest
    @CsvSource({
            "NY, New York",
            "CO, Denver",
            "VA, Fairfax",
            "TX, Arlington",
            "MA, Boston",
            "NY, New York",
            "MD, Annapolis"
    })
    // Write a parameterized test for this request
// GET https://api.zippopotam.us/us/{state}/{city}
    public void testStateCityToZip(String stateArg, String cityArg){
        System.out.println("stateArg = " + stateArg);
        System.out.println("cityArg = " + cityArg);

        given()
                .baseUri("https://api.zippopotam.us")
                .pathParam("state", stateArg)
                .pathParam("city", cityArg)
                .log().uri()
                .when()
                .get("/us/{state}/{city}")
                .then()
                .log().body()
                .statusCode(200)
                ;


    }



}
