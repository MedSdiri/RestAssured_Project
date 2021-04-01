package day5;

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

public class StarWarAPI_Test {

    @BeforeAll
    public static void init(){
        baseURI = "https://swapi.dev";
        basePath = "/api";

    }

    @AfterAll
    public static void cleanUp(){
        reset();
    }



}
/*
Interview Questions :
Send request to  GET https://swapi.dev/api/people/
Find out average height of all people showed up in the response
 */