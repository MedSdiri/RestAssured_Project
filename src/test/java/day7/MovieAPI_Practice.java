package day7;
import io.restassured.path.json.JsonPath;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import pojo.SpartanPojo;
import test_util.SpartanNoAuthBaseTest;
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

    }





}
