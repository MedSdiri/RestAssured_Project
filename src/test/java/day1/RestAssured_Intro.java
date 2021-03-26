package day1;
import io.restassured.response.Response;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.*;
import static org.hamcrest.MatcherAssert.*;
import static org.hamcrest.Matchers.*;

@DisplayName("Intor to RestAssured ")
public class RestAssured_Intro {

    @DisplayName("Testing Hello endpoint")
    @Test
    public void testHelloEndPoint(){
        //http://54.92.150.105:8000/api
        String endPoint = "http://54.92.150.105:8000/api";

        Response response = get(endPoint + "/hello");
        // getting the status code from the response
        System.out.println("response.statusCode() = " + response.statusCode());

        //Getting Content-Type from Header from the response
        System.out.println("response.getHeader(\"Content-Type\") = " + response.getHeader("Content-Type"));

        //Getting Content-Type header using ready method
        System.out.println("response.contentType() = " + response.contentType());
        System.out.println("response.getContentType() = " + response.getContentType());

        //getting Response body as String
        System.out.println("response.asString() = " + response.asString());

        //asserting that the status code is correct both ways
        assertThat(response.statusCode(), is(200));
        assertThat(response.getStatusCode(), equalTo(200));

        //getting time spent for execution
        System.out.println("response.time() = " + response.time());
        System.out.println("response.getTime() = " + response.getTime());

        assertThat(response.contentType(), is("text/plain;charset=UTF-8"));
        // Printing the results
        System.out.println("++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++");

        response.prettyPrint();
        response.prettyPeek();


    }

    @DisplayName("Testing GET/ api/spartans/{id} endpoint")
    @Test
    public void testSingleSpartan(){
        //http://54.92.150.105:8000/api
        String baseUrl = "http://54.92.150.105:8000/api";
        String resource = "/spartans/100";
        Response response = get(baseUrl + resource);
        //response.prettyPrint();

        assertThat(response.statusCode(), is(200));
        assertThat(response.contentType(), is("application/json"));

        System.out.println("++++++++++++++++++++++");
        System.out.println("response.path(\"id\") = " + response.path("id"));
        System.out.println("response.path(\"name\") = " + response.path("name"));
        System.out.println("response.path(\"gender\") = " + response.path("gender"));
        System.out.println("response.path(\"phone\") = " + response.path("phone"));

        // save id and  anem into specific data type

        int myId = response.path("id");
        String myName = response.path("name");
        int myPhone = response.path("phone");

        System.out.println("myId = " + myId);
        System.out.println("myName = " + myName);
        System.out.println("myPhone = " + myPhone);

    }




}
