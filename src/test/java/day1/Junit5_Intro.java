package day1;

import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;

//setting display name of the test class in test result using @Disp[layName


@DisplayName("Testing numbers")
public class Junit5_Intro {

    @BeforeAll
    public static void init(){
        System.out.println("Before all is running !!!");
    }

    @AfterAll
    public static void close(){
        System.out.println("After all is running !!!!");
    }
    @BeforeEach
    public void initEach(){
        System.out.println("!!!!!! Before each is running !!!!!!!!");
    }

    @AfterEach
    public void closeEach(){
        System.out.println("????  After Each is running ????");
    }

    @DisplayName("Testing numbers")
    @Test
    public void test() {
        System.out.println("Learning JUnit5");
        assertEquals(1,1);
        //assertEquals(1, 2, "Trying out the error message");

    }
    // add one more Test to assert your name first character starts with letter A

    @DisplayName("Testing name")
    @Test
    public void testName(){
        String name = "Ahmed";
     assertEquals('A', name.charAt(0), "You gone crazy man");
        System.out.println("Trying a very simple test");
    }



}
