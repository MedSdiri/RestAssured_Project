package day5;

import io.restassured.path.json.JsonPath;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;
import static io.restassured.RestAssured.* ;
import static org.hamcrest.Matchers.* ;
public class MovieAPI_Practice {
    @DisplayName("Search movies JsonPath practice")
    @Test
    public void testSearch(){
        JsonPath jp =
        given()
                .baseUri("http://www.omdbapi.com")
                .log().all()
                .queryParam("apikey", "678655de")
                .queryParam("s", "superman")
                .queryParam("type", "series")
                .when()
                .get()
                .then()
                .log().all()
                .statusCode(200)
        .extract()
        .jsonPath()
                ;

        List<String> allTitles = jp.getList("Search.Title", String.class);

        System.out.println("allTitles = " + allTitles);

        //assertThat(allTitles.size(), is(10));
       assertThat(allTitles, hasSize(10));
       assertThat(allTitles.get(0), containsString("Superman"));
       assertThat(allTitles, hasItem("Superman and Lois"));
       assertThat(allTitles, hasItems("Superman and Lois" , "The New Adventures of Superman"));
       assertThat(allTitles, everyItem(containsString("Superman")));




    }




}