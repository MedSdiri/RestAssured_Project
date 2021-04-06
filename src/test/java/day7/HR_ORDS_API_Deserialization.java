package day7;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import pojo.*;
import test_util.HR_ORDS_API_BaseTest;
import io.restassured.path.json.JsonPath;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
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
        //System.out.println(c1);
        Country thirdCountry = get("/countries")
                .jsonPath()
                .getObject("items[2]", Country.class);

        List<Country> allCountries =
                get("/countries")
                .jsonPath().getList("items", Country.class);

        System.out.println("thirdCountry = " + thirdCountry);
        System.out.println("allCountries = " + allCountries);
    }

    @DisplayName("Get /employees")
    @Test
    public void testAllEmployees(){
        Employee e1 =
                get("/employees")
                .jsonPath()
                .getObject("items[0]", Employee.class);
        System.out.println("e1 = " + e1);
    }

    @DisplayName("Get /departments")
    @Test
    public void testAllDepartments(){

        Department d1 =
                get("/departments")
                .jsonPath()
                .getObject("items[0]", Department.class);

        System.out.println("d1 = " + d1);


    }


}
