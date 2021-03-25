package day2;

import static org.hamcrest.Matchers.*;
import org.junit.jupiter.api.Test;

import static org.hamcrest.MatcherAssert.*;

public class HamcrestMatchersIntro {

    @Test
    public void simpleTest1(){

        assertThat(10, is(5+5));

    }

}
