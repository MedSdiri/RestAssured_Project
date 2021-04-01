package day5;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.junit.jupiter.api.Assertions.*;

public class ParametrizedTestInJunit5 {

    @ParameterizedTest
    @ValueSource( ints = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10})
    public void testPrintMultipleIteration(int num){
        //int num = 10;
        System.out.println("num = " + num);
        assertTrue( num > 5 );

    }

    @ParameterizedTest
    @ValueSource(strings =  {"Ercan", "Ahmed", "Anna", "Azad"})
    public void testNames(String name){
        System.out.println("name = " + name);
        assertTrue(name.length() >= 4);
    }
    // SEND GET REQUEST TO http://api.zippopotam.us/us/{zipcode}
    // with these zipcodes 22030,22031, 22032, 22033 , 22034, 22035, 22036
    //check status code is 200

    @ParameterizedTest
    @ValueSource(shorts = {22030,22031, 22032, 22033 , 22034, 22035, 22036})
    public void tesZipCodes(short codes){
        System.out.println("codes = " + codes);

    }

}
