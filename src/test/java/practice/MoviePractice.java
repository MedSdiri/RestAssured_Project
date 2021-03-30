package practice;

import io.restassured.response.Response;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.*;

public class MoviePractice {
        @BeforeAll
        public static void init() {
            baseURI = "http://www.omdbapi.com/";
            //basePath = "/api";

        }

        @AfterAll
        public static void cleanUp() {
            reset();
        }

        @Test
    public void testOne(){
          Response response = given()
                    .log()
                    .all()
                    .queryParam("apiKey", "678655de")
                    .queryParam("s", "The hurt locker")
                    .when()
                    .get()

                   ;

          response.prettyPrint();
        }

    }


// key 678655de