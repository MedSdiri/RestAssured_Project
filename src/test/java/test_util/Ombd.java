package test_util;
import io.restassured.RestAssured;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;

public abstract class Ombd {

    public static void init(){
        RestAssured.baseURI = "http://www.omdbapi.com";


    }

}

//url http://www.omdbapi.com/
// key 678655de
