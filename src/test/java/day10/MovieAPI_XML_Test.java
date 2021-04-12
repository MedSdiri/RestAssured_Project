package day10;
import io.restassured.path.xml.XmlPath;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static io.restassured.RestAssured.*;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;
import static org.junit.jupiter.api.Assertions.assertAll;
public class MovieAPI_XML_Test  {
    //KEY = 678655de
    public String keyAPI = "678655de";



    @DisplayName("Get movie attributes in xml")
    @Test
    public void testAttributes(){

        XmlPath xp = given()
                .baseUri("http://www.omdbapi.com")
                .queryParam("apikey",keyAPI)
                .queryParam("t","Superman")
                .queryParam("r","xml").
                        when()
                .get()
                .xmlPath() ;
        String title = xp.getString("root.movie.@title") ;
        System.out.println("title = " + title);


    }
    @DisplayName("Get movies attributes in xml")
    @Test
    public void testAllMovieAttributes(){

        XmlPath xp = given()
                .baseUri("http://www.omdbapi.com")
                .queryParam("apikey",keyAPI)
                .queryParam("s","Superman")
                .queryParam("r","xml").
                        when()
                .get()
                .xmlPath() ;
        List<String> allTitles = xp.getList("root.result.@title", String.class);
        System.out.println("allTitles = " + allTitles);


    }



    @AfterAll
    public static void teraDown(){
        reset();
    }

}
