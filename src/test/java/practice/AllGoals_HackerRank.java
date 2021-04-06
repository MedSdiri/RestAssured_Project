package practice;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.junit.jupiter.api.*;

import static org.hamcrest.MatcherAssert.*;
import static io.restassured.RestAssured.* ;
import static org.hamcrest.Matchers.* ;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class AllGoals_HackerRank {
    @BeforeAll
    public static void init(){
        baseURI = "http://jsonmock.hackerrank.com" ;
        basePath = "/api" ;
    }


    @AfterAll
    public static void cleanUp(){
        reset();
    }


    @DisplayName("return the total goals scored by a team in the whole season")
    @Test
    public void goalsOfSeason(){
        totalGoalsPerSeason("Arsenal", 2014);
    }

public static void totalGoalsPerSeason(String team, int year){
    int totalAwayGoals = 0;
    int totalHomeGoals = 0;

    //To get the number of pages
    int pageCount =
            given()
                    .queryParam("year", year)
                    .queryParam("team1", team)
                    .when()
                    .get("/football_matches")
                    .then()
                    .extract()
                    .jsonPath()
                    .getInt("total_pages")
            ;

    //List to store all goals scored at home
    List<Integer> homeGoals = new ArrayList<>();
    //List to store all goals scored away
    List<Integer> awayGoals = new ArrayList<>();
    //Loop through the pages and returns the number of goals scored per each page
    for (int perPage = 1; perPage <= pageCount ; perPage++){

        homeGoals.addAll(
                given()
                        .queryParam("year", year)
                        .queryParam("team1", team)
                        .queryParam("page", perPage)
                        .when()
                        .get("/football_matches")
                        .jsonPath()
                        .getList("data.team1goals", Integer.class)

        );
        awayGoals.addAll(
                given()
                        .queryParam("year", year)
                        .queryParam("team2", team)
                        .queryParam("page", perPage)
                        .when()
                        .get("/football_matches")
                        .jsonPath()
                        .getList("data.team2goals", Integer.class)

        );




    }
    //Loop to sum the number of goals
    for (int i =0 ; i < homeGoals.size(); i++){
        totalHomeGoals += homeGoals.get(i);
        totalAwayGoals += awayGoals.get(i);
    }



    System.out.println("Total goals scored at home games = " + totalHomeGoals);
    System.out.println("Total goals scored at away games = " + totalAwayGoals);
    System.out.println("Total goals for the season = " + (totalAwayGoals+totalHomeGoals));

    System.out.println("+++++++___________________+++++++++");
    System.out.println("homeGoals = " + homeGoals);
    System.out.println("awayGoals = " + awayGoals);




}




    }



/* This is a hacker rank challenge give in the interview
        * Given this endpoint for getting football match data
        * http://jsonmock.hackerrank.com/api/football_matches
        * below query params are available
        * year  :  year the match occurred
        * team1 :  home team name
        * team2 :  visiting team name
        * page  :  page number , max result in per response is 10
        *           any result more than 10 will be on next pages
        *           so in order to get all data you need to
        *           make separate requests until there are no more pages
        *
        * Response Format :
        *  {
        *     "page": "1",
        *     "per_page": 10,
        *     "total": 23,
        *     "total_pages": 3,
        *     "data": [
        *         {
        *             "competition": "UEFA Champions League",
        *             "year": 2012,
        *             "round": "GroupB",
        *             "team1": "Arsenal",
        *             "team2": "Olympiacos",
        *             "team1goals": "3",
        *             "team2goals": "1"
        *         },
        *         {...},
        *         {...}
        *         ]
        *  }
        *
        * Examples Requests :
        *
        * GET http://jsonmock.hackerrank.com/api/football_matches?year=2012&team1=Arsenal&team2=Chelsea&page=1
        *  return data for match between Arsenal(home team) and Chelsea(visiting team) , show page 1
        * GET http://jsonmock.hackerrank.com/api/football_matches?year=2012&team1=Arsenal&page=1
        *  return data for 2012 match between Arsenal(home team) and any visiting team and show page 2
        * GET http://jsonmock.hackerrank.com/api/football_matches?year=2012&team2=Arsenal&page=2
        *  return data for match between any home team) and Chelsea(visiting team) and show page 2
        *
        *  Write a method to return total goals of a team in a given year
        *      * Include the both result where the team is home team or visiting team
        */