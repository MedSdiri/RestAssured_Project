package day9;
import org.junit.jupiter.api.Test;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;
public class AssertingInJunit5 {
    @Test
    public void testAdd(){
        assertThat(5+5 , equalTo(10)) ;
        assertThat(5+4 , equalTo(10)) ;
        assertThat(5+6 , equalTo(10)) ;




    }


}