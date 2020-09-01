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

public class spartansTest_Parameter {
    @BeforeAll
    public static void setUp() {

        RestAssured.baseURI= "http://54.89.28.41:8000";
        RestAssured.basePath= "/api" ;
    }
    @DisplayName( "Testing/spartans/{id}" )
    @Test
    public void testingSingleSpartan(){

        given()
                .log().all()
                .pathParam( "id",248 ).
        when()
                .get("spartans/{id}").
        then()
                .statusCode( is( 200 ) );


    }
    @DisplayName( "02Testing/spartans/{id}" )
    @Test
    public void testingSingleSpartan02(){


        given()
                .log().all().
                when()
                .get("spartans/{id}" , 248 ).
                then()
                .statusCode( is(200))

        ;

    }
    @DisplayName("Testing /spartans/{id} Body")
    @Test
    public void testSingleSpartanBody(){
        given()
                .log().all()
                .pathParam( "id",248 ).

                when()
                .get("spartans/{id}" ).
                then()
                .log().all()
                .statusCode( is( 200 ) )
                //.body( "JSON PATH",is( "THE VALUE" ) )
                  .body( "id",is( 248 ) )
                  .body( "name",is( "quos" ) )
                  .body( "gender",is( "Male" ) )
                  .body( "phone",is( 5108576689L ) )

        ;

    }
}
