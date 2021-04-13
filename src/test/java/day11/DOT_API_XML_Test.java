package day11 ;
import org.junit.jupiter.api.*;
import io.restassured.path.xml.XmlPath;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import java.util.Collections;
import java.util.List;
import static io.restassured.RestAssured.*;
import static org.hamcrest.MatcherAssert.*;
import static org.hamcrest.Matchers.*;
import static org.junit.jupiter.api.Assertions.assertAll;

public class DOT_API_XML_Test {
    @BeforeAll
    public static void init(){
        baseURI = "https://vpic.nhtsa.dot.gov" ;
        basePath = "/api/vehicles" ;
    }
    @AfterAll
    public static void cleanup(){
        reset();
    }
    /*
    Send GET Request to https://vpic.nhtsa.dot.gov/api/vehicles/GetMakeForManufacturer/988?format=xml
    and verify the
    count element text is 2
    message Results returned successfully
    first Make_ID is  474 , Make_Name Honda
     */
    @DisplayName("XML Test with Vehicles API /GetMakeForManufacturer/988?format=xml")
    @Test
    public void testHonda(){
        XmlPath xp =
        given()
                .queryParam("format", "xml")
                .when()
                .get("/GetMakeForManufacturer/988")
                .then()
                     .statusCode(200)
        .log().body()
        .extract()
        .xmlPath()
                ;

        int countElementText = xp.getInt("Response.Count");
        System.out.println("countElementText = " + countElementText);

        String message = xp.getString("Response.Message");
        System.out.println("message = " + message);

        int makeId1 = xp.getInt("Response.Results.MakesForMfg[0].Make_ID");
        System.out.println("makeId1 = " + makeId1);

        String makeName1 = xp.getString("Response.Results.MakesForMfg[0].Make_Name");
        System.out.println("makeName1 = " + makeName1);

       assertThat(countElementText, is(2));
       assertThat(message, is("Results returned successfully"));
       assertThat(makeId1, is(474));
       assertThat(makeName1, equalToIgnoringCase("Honda"));

    }


    @DisplayName("XML Test with Vehicles API in method chain")
    @Test
    public void testHondaInMethodChain(){
        given()
                .queryParam("format","xml").
                when()
                .get("/GetMakeForManufacturer/988").
                then()
                .log().body()
                .statusCode(200)
        .body("Response.Count", is("2"))
        .body("Response.Message", is("Results returned successfully"))
        .body("Response.Results.MakesForMfg[0].Make_ID", is("474"))
        .body("Response.Results.MakesForMfg[0].Make_Name", is("HONDA"))
        ;


    }
}