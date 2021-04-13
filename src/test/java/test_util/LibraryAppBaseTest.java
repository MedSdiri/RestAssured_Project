package test_util;

import io.restassured.filter.log.LogDetail;
import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;

import static io.restassured.RestAssured.*;

public class LibraryAppBaseTest {
     public static String librarianToken;
     public static RequestSpecification librarianSpec;
     public static ResponseSpecification librarianResponseSpec;

    @BeforeAll
    public static void init(){

        baseURI  = "http://library1.cybertekschool.com" ;
        basePath = "/rest/v1" ;
        librarianToken =
                getToken("librarian69@library", "KNPXrm3S");
        librarianSpec = given()
                .header("x-library-token",librarianToken);
        librarianResponseSpec = expect().statusCode(200)
                .contentType(ContentType.JSON)
                .logDetail(LogDetail.ALL);


        String url = ConfigurationReader.getProperty("library1.database.url");
        String username = ConfigurationReader.getProperty("library1.database.username") ;
        String password = ConfigurationReader.getProperty("library1.database.password") ;
        DB_Utility.createConnection(url,username,password);


    }

    public static String getToken(String username, String password){

        return given()
                .contentType(ContentType.URLENC)
                .formParam("email", username)
                .formParam("password" , password).
                        when()
                .post("/login")
                .path("token");

    }


    @AfterAll
    public static void cleanup(){
        reset();
        DB_Utility.destroy();
    }



}
