package day10;
import io.restassured.path.xml.XmlPath;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.*;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;
import static org.junit.jupiter.api.Assertions.assertAll;
public class MovieAPI_XML_Test  {
    //KEY = 678655de
    public String keyAPI = "678655de";


    @BeforeAll
    public static void setupURI(){
        baseURI = "http://www.omdbapi.com";
    }

    @DisplayName("Get movie attributes in xml")
    @Test
    public void testAttributes(){
        XmlPath xp =
                given()
                .queryParam("apikey", keyAPI)
                .queryParam("t", "Superman")
                .queryParam()
    }



    @AfterAll
    public static void teraDown(){
        reset();
    }

}
