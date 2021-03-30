package day4;


import test_util.LibraryAppBaseTest;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.*;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;
public class LibraryAppAuthorizedRequestTest extends LibraryAppBaseTest {

    @DisplayName("GET /get_user_by_id/{user_id}")
    @Test
    public void testOneUser(){
        String myToken = getToken("librarian69@library", "KNPXrm3S");
        System.out.println("myToken = " + myToken);
        //we are sending request to this endpoint  : GET /get_user_by_id/1
        given()
                .log().all()
                .header("x-library-token", myToken)
                .pathParam("user_id", 1).
                when()
                .get("/get_user_by_id/{user_id}").
                then()
                .log().all()
                .statusCode(200)
        ;
    }



    @DisplayName("GET /get_all_users")
    @Test
    public void testGetAllUsers(){
        String myToken = getToken("librarian69@library", "KNPXrm3S");
        System.out.println("myToken = " + myToken);

        given()
                .header("x-library-token", myToken)
                .when()
                .get("/get_all_users")
                .then()
                .statusCode(200)
                ;

    }

}