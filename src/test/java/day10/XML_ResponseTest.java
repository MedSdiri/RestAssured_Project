package day10;
import io.restassured.http.ContentType;
import io.restassured.path.xml.XmlPath;
import io.restassured.response.Response;
import org.junit.jupiter.api.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.ValueSource;
import pojo.*;
import pojo.Character;
import test_util.*;
import io.restassured.path.json.JsonPath;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.*;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;
import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static test_util.DB_Utility.*;
import test_util.SpartanNoAuthBaseTest;

import javax.swing.text.Style;
import java.util.Map;

import test_util.SpartanWithAuthBaseTest;

public class XML_ResponseTest extends SpartanWithAuthBaseTest {

    @DisplayName("Test GET / spartans xml response")
    @Test
    public void textXML(){
        // provide credentials and provide header as xml and send request
        // assert status code 200
        // assert content type is xml
        // assert first data name is Wonder Woman

        given()
                .auth().basic("user", "user")
                .accept(ContentType.XML)
                .when()
                .get("/spartans")
                .then()
                .statusCode(200)
                //.log().all()
        .contentType(ContentType.XML)
        .contentType(ContentType.XML)
        .body("List.item[0].name", is("Meade"))
        .body("List.item[0].id", is("1"))

        ;

    }

    @DisplayName("Test GET / spartans xml response with xmlPath")
    @Test
    public void testXML_extractData(){
        Response response = given()
                .auth().basic("user","user")
                .accept( ContentType.XML ).
                        when()
                .get("/spartans")
                ;
        XmlPath xp = response.xmlPath();
        int firstId = xp.getInt("List.item[0].id");

        System.out.println("firstId = " + firstId);
        List<Integer> allIds = xp.getList("List.item.id");

        System.out.println("allIds = " + allIds);

        assertThat();


    }


}
