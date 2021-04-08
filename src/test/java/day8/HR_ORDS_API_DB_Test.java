package day8;

import org.junit.jupiter.api.Test;
import pojo.Region;
import test_util.DB_Utility;
import test_util.HR_ORDS_API_BaseTest;
import test_util.HR_ORDS_API_BaseTest;
import java.util.List;
import static io.restassured.RestAssured.*;
import static test_util.DB_Utility.*;
import static io.restassured.RestAssured.*;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;


public class HR_ORDS_API_DB_Test extends HR_ORDS_API_BaseTest {


    @Test
    public void hr_ORDS_TestWithDB(){
        runQuery("SELECT * FROM REGIONS WHERE REGION_ID = 1");
        displayAllData();

        Region r1 = given()
                .pathParam("region_id", 1)
                .get("/regions/{region_id}")
                .jsonPath()
                .getObject("items[0]", Region.class)
                ;
        System.out.println("r1 = " + r1);

        //get("/regions/{region_id}", 1)







    }


}
