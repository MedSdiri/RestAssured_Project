package day7;
import io.restassured.path.json.JsonPath;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.shadow.com.univocity.parsers.common.input.LineSeparatorDetector;
import pojo.Movie;
import pojo.Rating;
import pojo.SpartanPojo;
import test_util.SpartanNoAuthBaseTest;

import java.util.List;

import static io.restassured.RestAssured.*;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;


public class MovieAPI_Practice {

    // save the result of your request
    // SEND GET http://www.omdbapi.com/?t=Avenger&apikey=YOUR OWN API KEY goes here
    // Key = 678655de
    // save the response into Movie POJO , title Str, year int , Released str ,Language
    // ignore any unknown properties
    // match the json fields to pojo fields

    @DisplayName("Get http://www.omdbapi.com/?t=Avenger&apikey=678655de")
    @Test
    public void testMovieToPojo(){
        Movie m1 =
                given()
                .baseUri("http://www.omdbapi.com")
                .queryParam("t", "Avenger")
                .queryParam("apikey", "678655de")
                .when()
                .get()
                .jsonPath()
                .getObject("", Movie.class);
        System.out.println("m1 = " + m1);
        Movie m2 =
                given()
                        .baseUri("http://www.omdbapi.com")
                        .queryParam("t", "Avenger")
                        .queryParam("apikey", "678655de")
                        .when()
                        .get()
                .as(Movie.class);
        //System.out.println("m2 = " + m2);



    }


    @DisplayName("GET Search for avenger and save Ratings field into List<Rating>")
    @Test
    public void testMovieRatingToPOJO(){
        List<Rating> allRating =
        given()
                .baseUri("http://www.omdbapi.com")
                .queryParam("t", "Avenger")
                .queryParam("apikey", "678655de")
                .when()
                .get()
                .jsonPath()
                .getList("Ratings", Rating.class);

        System.out.println("allRating = " + allRating);

    }





}
