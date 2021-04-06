package day7;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import pojo.Country;
import pojo.Region;
import test_util.HR_ORDS_API_BaseTest;
import io.restassured.path.json.JsonPath;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import pojo.SpartanPojo;
import test_util.SpartanNoAuthBaseTest;
import static io.restassured.RestAssured.*;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;
import java.util.List;

public class HR_ORDS_API_Deserialization extends HR_ORDS_API_BaseTest {

    @DisplayName("Get /regions")
    @Test
    public void getAllRegionsSaveTOList(){

        List<Region> allRegions =
                get("/regions")
                .jsonPath()
                .getList("items", Region.class);

        //System.out.println("allRegions = " + allRegions);
        allRegions.forEach(p -> System.out.println(p));


    }

    @DisplayName("Get /Countries")
    @Test
    public void testALlCountries(){
        Country c1 = new Country("AR", "Argentina", 1);
        System.out.println(c1);
    }


}
