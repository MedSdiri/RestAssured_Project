package day8;

import org.junit.jupiter.api.Test;
import test_util.DB_Utility;
import test_util.HR_ORDS_API_BaseTest;
import test_util.HR_ORDS_API_BaseTest;
import java.util.List;
import static io.restassured.RestAssured.*;


public class HR_ORDS_API_DB_Test extends HR_ORDS_API_BaseTest {


    @Test
    public void hr_ORDS_TestWithDB(){
        DB_Utility.runQuery("SELECT * FROM REGIONS");
        DB_Utility.displayAllData();
    }


}
