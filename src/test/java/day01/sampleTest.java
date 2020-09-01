package day01;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class sampleTest {

    @Test
    public void calculatorTest(){
        System.out.println("hello world");
        assertEquals( 9,4+5 );

    }
    @DisplayName( "I am testing the name" )
    @Test
    public void nameTest(){
    Assertions.assertEquals( "bahtiyar muhsin","bahtiyar"+" muhsin" );
    }
}
