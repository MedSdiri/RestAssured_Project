package day5;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

public class MethodSourceParamTest {

    @ParameterizedTest
    @MethodSource("getManyNames")
    public void testPrintNames(String name){

        System.out.println("name = " + name);

    }
//    public static Stream<String> getManyNames(){
//        List<String> nameList = Arrays.asList("Emre", "Mustafa", "Diana", "Tucky", "Erjon", "Saya", "Afrooz");
//        return nameList.stream();
//    }


    public static List<String> getManyNames(){
        List<String> nameList = Arrays.asList("Emre", "Mustafa", "Diana", "Tucky", "Erjon", "Saya", "Afrooz");
    return nameList;
    }

}
