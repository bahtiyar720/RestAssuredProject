package day02;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static io.restassured.RestAssured.* ;
import static io.restassured.matcher.RestAssuredMatchers.* ;
import static org.hamcrest.Matchers.*;

import static io.restassured.RestAssured.when;

public class practice01 {
    @DisplayName( "get all charecter simple test" )
    @Test
    public void testBreakingBad(){
        when()
                .get("https://www.breakingbadapi.com/api/characters").
                prettyPeek().
        then()
              .statusCode( is(200) )
                .header("Content-Type", is("application/json; charset=utf-8") )
        ;

    }
}
