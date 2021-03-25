package day2;

import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;

//setting display name of the test class in test result using @Disp[layName


@DisplayName("Testing numbers")
public class Junit5_Intro {

    @DisplayName("Testing numbers")
    @Test
    public void test() {

        System.out.println("Learning JUnit5");
        //assertEquals(1,1);
        //assertEquals(1, 2, "Trying out the error message");

    }
    // add one more Test to assert your name first character starts with letter A

    @DisplayName("Testing name")
    @Test
    public void testName(){
        String name = "Ahmed";
     assertEquals('A', name.charAt(0), "You gone crazy man");
    }

}
