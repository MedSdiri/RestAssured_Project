package day1;

import org.junit.jupiter.api.*;
import test_util.SpartanNoAuthBaseTest;

import static org.hamcrest.MatcherAssert.assertThat;
import static io.restassured.RestAssured.* ;

@DisplayName("Spartan App Get Requests")
public class SpartanNoAuthTest extends SpartanNoAuthBaseTest {

    @Test
    public void sayHello(){
        // the actual request url you have sent is this
        // baseURI + basePath + "/hello"
        get("/hello").prettyPeek();
    }

    @Test
    public void getAllSpartans(){
        // the actual request url you have sent is this
        // baseURI + basePath + "/spartans"
        get("/spartans").prettyPeek() ;




    }




}