package day01;

import io.restassured.RestAssured;
import io.restassured.matcher.ResponseAwareMatcher;
import io.restassured.response.Response;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;
import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class RestAssureMethodChaining {
    @DisplayName("Fisrt Attemp for chaining")
    @Test
    public void chainingMethodsTest() {

        when().
                get( "http://54.89.28.41:8000/api/hello" ).
                then().
                statusCode( 200 ).
                header( "Content-Length","17" );

    }
    @DisplayName( "Using Hamcrest matcher for assertion" )
    @Test
    public void testingWithMatcher(){
        when().
                get("http://54.89.28.41:8000/api/hello").
        then().
                statusCode( is( 200 ) ).
                header( "Content-Length",equalTo( "17" ) ).
                header( "Content-Type",is( "text/plain;charset=UTF-8" ) ).
                body( is( "Hello from Sparta" ) );

    }
    @Test
    public void testAllSpartan(){
        given().
                header( "Accept","application/xml" ).
        when().
                get("http://54.89.28.41:8000/api/spartans").
                prettyPeek().
        then().
                statusCode( is( 200 ) );

    }

}
