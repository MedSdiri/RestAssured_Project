package day8;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import pojo.Region;
import test_util.DB_Utility;
import test_util.HR_ORDS_API_BaseTest;
import test_util.HR_ORDS_API_BaseTest;
import java.util.List;
import java.util.Map;

import static io.restassured.RestAssured.*;
import static test_util.DB_Utility.*;
import static io.restassured.RestAssured.*;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;

import test_util.LibraryAppBaseTest;

public class Library_API_DB_Test extends LibraryAppBaseTest {

    //Set up DB connection in base test
    @Test
    public void testDashbardStatsNumbers(){

        runQuery("SELECT COUNT(*) FROM books");
        //System.out.println(getFirstRowFirstColumn());
        String expectedBookCount = getFirstRowFirstColumn();
        //System.out.println("expectedBookCount = " + expectedBookCount);

        runQuery("SELECT COUNT(*) FROM users");
        String expectedUserCount = getFirstRowFirstColumn();

        runQuery("SELECT COUNT(*) FROM book_borrow WHERE returned_date IS NULL");
        String expectedBorrowedBookCount = getFirstRowFirstColumn();

        given()
                .header("X-LIBRARY-TOKEN", librarianToken)
                .when()
                .get("/dashboard_stats")
                .then()
                .log().body()
                .statusCode(200)
                .body("book_count", is(expectedBookCount))
                .body("borrowed_books", is(expectedBorrowedBookCount))
                .body("users", is(expectedUserCount))
                ;



        given()
                .header("X-LIBRARY-TOKEN", librarianToken)
                .expect()
                .log().body()
                .statusCode(200)
                .body("book_count", is(expectedBookCount))
                .body("borrowed_books", is(expectedBorrowedBookCount+123))
                .body("users", is(expectedUserCount))
                .when()
                .get("/dashboard_stats")

        ;


    }

}
