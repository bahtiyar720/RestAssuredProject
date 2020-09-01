package day03;

import io.restassured.RestAssured;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;

public class Practice01 {
    @BeforeAll
    public static void init() {
        RestAssured.baseURI = "http://54.89.28.41";
        RestAssured.port = 8000;
        RestAssured.basePath = "/api";
    }

    @DisplayName("simple Test")
    @Test
    public void test01() {
        given()
                .log().all()
                .queryParam( "gender", "Female" )
                .when()
                .get( "/spartans/search" ).
                then()
                .statusCode( 200 );
    }
}
