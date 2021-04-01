package day5;

import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.junit.jupiter.api.*;

import static org.hamcrest.MatcherAssert.*;
import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class StarWarAPI_Test {

    @BeforeAll
    public static void init() {
        baseURI = "https://swapi.dev";
        basePath = "/api";

    }

    @AfterAll
    public static void cleanUp() {
        reset();
    }

    @DisplayName("Get average height from GET /people response")
    @Test
    public void testGetAverageHeight() {

        List<Integer> allHeights =
                get("/people")
                        .jsonPath()
                        .getList("results.height", Integer.class);
        System.out.println("allHeights = " + allHeights);
        // get average height
        int total = 0;
        for (Integer each : allHeights) {
            total += each;
        }
        int average = total / allHeights.size();
        System.out.println("average = " + average);
        // Above code will only retrieve first page that include 10 people
// but we have more than 10 people in star war
// we can get total count of people in first response count field
// the decide how many page we have to go through by sending more request
// then loop through the rest of the pages to add all heights to the list
// and calculate the average from final list
// in order to go to next page we can use
// page query parameter to decide which page we want to see
// HERE IS THE STEPS :
// Create an empty Integer empty list
//  Send GET /people -->>
        // capture the total count using jsonPath
        // save first page heights into the list
//  Loop : from page 2 till last page
        // get the list of height integer using jsonPath
        // add this to the big list




    }
    @DisplayName("Get all heights from all the pages and find average")
    @Test
    public void testGetAllPagesAverageHeight(){
        List<Integer> allHeights = new ArrayList<>();

        JsonPath jp =
                get("/people")
                .jsonPath();
        int peopleCount = jp.getInt("count");
        int pageCount = (peopleCount % 10 ==0 )? peopleCount/10 : (peopleCount/10)+1;


        List<Integer> firstPageHeights = jp.getList("results.height");
        allHeights.addAll(firstPageHeights);

        for (int page=2; page <= pageCount; page++ ){
            List<Integer> heightsOnThisPage =
                    get("/people?page="+page)
                    .jsonPath().getList("results.height");
            allHeights.addAll(heightsOnThisPage);
        }

        //System.out.println("allHeights = " + allHeights);
        allHeights.remove("unknown");
        System.out.println("allHeights = " + allHeights);


    }

//result.height


}
/*
Interview Questions :
Send request to  GET https://swapi.dev/api/people/
Find out average height of all people showed up in the response
 */