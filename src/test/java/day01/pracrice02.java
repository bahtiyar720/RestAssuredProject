package day01;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;
public class pracrice02 {
    @Test
    public void test1(){
        int num1 = 5;
        int num2 = 4;
        assertThat(num1+num2,is( 9 ));
        assertThat( num1+num2,equalTo( 9 ) );
        assertThat( num1+num2,is( equalTo( 9 ) ) );

        assertThat( num1+num2,not( 11 ) );
        assertThat( num1+num2,is( not( 11 ) ) );

        String fisrtname = "Bahtiyar";
        String lastname = "muhsin";

        assertThat( fisrtname+" "+lastname,is( "Bahtiyar muhsin" ) );
        assertThat( fisrtname+" "+lastname,equalTo( "Bahtiyar muhsin" ) );
        assertThat( fisrtname+" "+lastname,is( equalTo( "Bahtiyar muhsin" ) ) );

        assertThat( fisrtname+" "+lastname,not( "Akbar" ) );
        assertThat( fisrtname+" "+lastname,is( not( "Akbar" ) ) );
    }
    @DisplayName( "Support for collection" )
    @Test
    public void test2(){
        List<Integer>numlist= Arrays.asList( 11,44,3,55,88,5 );
        assertThat( numlist,hasSize( 6 ) );
        assertThat( numlist.get( 2 ),is( 3 ) );

    }
}
