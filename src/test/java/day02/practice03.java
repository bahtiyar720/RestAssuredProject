package day02;

import org.junit.jupiter.api.*;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static io.restassured.RestAssured.* ;
import static io.restassured.matcher.RestAssuredMatchers.* ;
import static org.hamcrest.Matchers.*;

public class practice03  {
    @BeforeAll
    public static void setUp() {

        RestAssured.baseURI= "http://54.89.28.41:8000";
        RestAssured.basePath= "/api" ;
    }

    @DisplayName( "testing / hello again" )
    @Test
    public void testHello(){
        given()
                .accept( ContentType.TEXT ).
                when()
                .get("/hello").
                then().
                statusCode( is( 200 ) )
                .contentType( ContentType.TEXT )
                .body( equalTo( "Hello from Sparta" ) );
    }
    @DisplayName("Get 1 Spartan Test")
    @Test
    public void testSingleSpartan(){
        given()
                .log().uri().

        when()
                .get("/spartans/248")
                //.prettyPeek().
        .then()
                .log().body()
                .statusCode( is( 200 ) )
        ;
    }
}
