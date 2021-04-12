package day10;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import test_util.SpartanNoAuthBaseTest;
import static io.restassured.RestAssured.*;
import static io.restassured.module.jsv.JsonSchemaValidator.matchesJsonSchemaInClasspath;

public class jsonSchemaValidationTest extends SpartanNoAuthBaseTest {


    @DisplayName("Check GET /spartans/{id} json schema")
    @Test
    public void test1SpartanJsonSchema(){
        given()
                .pathParam("id", 100)
                .when()
                .get("/spartans/{id}")
                .then()
                .log().body()
                .statusCode(200)
        .body(matchesJsonSchemaInClasspath("singleSpartanSchema.json"))
                ;
    }

    @DisplayName("check GET /spartans json schema")
    @Test
    public void testAllSpartansJsonSchema(){
        when()
                .get("/spartans")
                .then()
                .body(matchesJsonSchemaInClasspath("allSpartansSchema.json"))
                ;
    }
}