package day11;
import io.restassured.http.ContentType;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import pojo.Spartan;
import spartan_util.SpartanUtil;
import test_util.SpartanNoAuthBaseTest;
import test_util.SpartanWithAuthBaseTest;

import java.io.File;

import static io.restassured.RestAssured.*;
import static io.restassured.module.jsv.JsonSchemaValidator.matchesJsonSchema;
import static io.restassured.module.jsv.JsonSchemaValidator.matchesJsonSchemaInClasspath;

public class SpartanPostSchema extends SpartanWithAuthBaseTest {

    @DisplayName("Test Json Schema for Post Response")
    @Test
    public void testAddSpartanResponse(){
        Spartan bodyPojo = SpartanUtil.getRandomSpartanPOJO();
        System.out.println("bodyPojo = " + bodyPojo);
        given()
                .auth().basic("admin", "admin")
                .contentType(ContentType.JSON)
                .body(bodyPojo)
                .when()
                .post("/spartans")
                .then()
                .statusCode(201)
                .body(matchesJsonSchemaInClasspath("spartanPostJsonSchema.json"))
                ;


    }

}
