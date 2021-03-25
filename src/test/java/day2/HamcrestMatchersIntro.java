package day2;

import static org.hamcrest.Matchers.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.hamcrest.MatcherAssert.*;

public class HamcrestMatchersIntro {

    @DisplayName("First Matchers just numbers")
    @Test
    public void simpleTest1(){

        assertThat(10, is(5+5));
        assertThat(5+5, equalTo(10));
        assertThat(5+5, not(21));
        assertThat(5+5, is(greaterThan(9)));

// Number comparison
// greaterThan()
//lessThan()
//greaterThanOrEqualTo()
//lessThanOrEqualTo()
    }


    @DisplayName("Matchers Related to Strings")
    @Test
    public void stringMatchers(){
        String message = "B21 is learning Hamcrest";

        // checking for equality
        assertThat(message, is("B21 is learning Hamcrest"));
        assertThat(message, equalTo("B21 is learning Hamcrest"));
        assertThat(message, is( equalTo("B21 is learning Hamcrest")));

        // check if this message starts with b21
        assertThat(message, startsWith("B21"));

        // chewck if the message ends with rest
        assertThat(message, endsWith("rest"));

        //check if a message contains a String learning
        assertThat(message, containsString("learning"));
        assertThat(message, containsStringIgnoringCase("LeARNING"));

        String str = "       ";
        //asert that the String is blank
        assertThat(str, is(blankString()));
        // check if a trimmed str is empty string
        assertThat(str.trim(), is(emptyString()));

    }

    @DisplayName("Hamcrest Support for collections")
    @Test
    public void testCollection(){
        List<Integer> list = Arrays.asList(1,4,7,3,7,44,88,99,44);

        //checking the sise of this list
        assertThat(list, hasSize(9));
        // check if the list has the item 7
        assertThat(list, hasItem(7));
        //check if this list hasItems 7,9,88
        assertThat(list, hasItems(7,99,88) );


    }





}

