package day10;
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

    }


}
