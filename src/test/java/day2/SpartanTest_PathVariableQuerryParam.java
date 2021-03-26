package day2;
import test_util.SpartanNoAuthBaseTest;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.junit.jupiter.api.*;
import test_util.SpartanNoAuthBaseTest;

import static org.hamcrest.MatcherAssert.assertThat;
import static io.restassured.RestAssured.* ;
import static org.hamcrest.Matchers.* ;
import test_util.SpartanNoAuthBaseTest;

@DisplayName("Spartan Test with a Path variable and query param")
public class SpartanTest_PathVariableQuerryParam extends SpartanNoAuthBaseTest {

    @Test
    public void getOneSpartan(){
    //get("/spartans/100").prettyPrint();

    // Iwant to provide 100 as path variable|parameter
    // I want to provide accept header
        given()
                .header("Accept", "application/json")
                .pathParam("spartan_id", "100")
                .when()
                .get("/spartans/{spartan_id}").prettyPrint();






}


}
