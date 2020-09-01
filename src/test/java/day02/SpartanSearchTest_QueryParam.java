package day02;

import io.restassured.RestAssured;
import io.restassured.RestAssured;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;

public class SpartanSearchTest_QueryParam {

    @BeforeAll
    public static void init() {

        RestAssured.baseURI = "http://54.89.28.41:8000";
        RestAssured.basePath = "/api";

    }
    @DisplayName( "testing/spartan/search endpoint" )
    @Test
    public void testSearch(){
        given().
                log().all().
                queryParam( "gender","male" ).
                queryParam("nameContains","B").
                when().
                get("/spartans/search").
                then()
                .log().all()
                .statusCode( 200 );
    }

}
