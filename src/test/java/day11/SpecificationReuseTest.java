package day11;
import io.restassured.filter.log.LogDetail;
import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import io.restassured.response.Response;
import static io.restassured.RestAssured.*;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;
import test_util.SpartanWithAuthBaseTest;

public class SpecificationReuseTest extends SpartanWithAuthBaseTest {
    private static RequestSpecification requestSpec =
            given()
                    .log().all()
                    .auth().basic("admin", "admin")
                    .accept(ContentType.JSON)
            ;
    private static ResponseSpecification responseSpec = expect()
            .logDetail(LogDetail.ALL)
            .statusCode(200)
            .contentType(ContentType.JSON)
            ;
    @DisplayName("Admin GET /spartans and expect 200 and json")
    @Test
    public void testAdminGetAll(){


        given()
                .spec(requestSpec)
                .when()
                .get("/spartans")
                .then()
                .spec(responseSpec)
//                .statusCode(200)
//                .contentType(ContentType.JSON)
                ;
    }

    @DisplayName("Admin GET /spartans/{id} and expect 200 and json, expect id match")
    @Test
    public void testAdminGetOne(){
        given()
                .spec(requestSpec)
//                .auth().basic("admin", "admin")
//                .accept(ContentType.JSON)
                .pathParam("id", 1)
                .when()
                .get("/spartans/{id}")
                .then()
                //.log().body()
        .spec(responseSpec)
//                .statusCode(200)
//                .contentType(ContentType.JSON)
        ;
    }
}
