package test_util;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;

import static io.restassured.RestAssured.*;

public abstract class HR_ORDS_API_BaseTest {

    @BeforeAll
    public static void init(){
        baseURI = ConfigurationReader.getProperty("hr.ords.baseuri");
        basePath = "/ords/hr/api" ;
        String url = ConfigurationReader.getProperty("hr.database.url");
        String username = ConfigurationReader.getProperty("hr.database.username");
        String password = ConfigurationReader.getProperty("hr.database.password");
        DB_Utility.createConnection(url,username,password);
    }

    @AfterAll
    public static void cleanUp(){
        reset();
        DB_Utility.destroy();
    }
}
