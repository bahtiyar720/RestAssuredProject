package day02;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.is;

public class zipcodeTest {
    @BeforeAll
    public static void init() {

        RestAssured.baseURI = "http://api.zippopotam.us";
        RestAssured.basePath = "/us";

    }

    @Test
    @DisplayName("Zip to City Test")
    public void testZipToCity() {

        given()
                .pathParam( "zip", 94578 ).
                log().all().
                when()
                .get( "/{zip}" ).
                then()
                .log().all()
                .statusCode( is( 200 ) )
                .contentType( ContentType.JSON )
                .body( "'post code'", is( "94578" ) )
                .body( "country", is( "United States" ) )
                .body( "places[0].longitude", is( "-122.124" ) )
                .body( "places[0].state", is( "California" ) )
                .body( "places[0].'place name'", is( "San Leandro" ) )

        ;


    }
    @Test
    @DisplayName("city to Zip Test")
    public void testcityToZip() {

        given()
                .pathParam( "state","CA" )
                .pathParam( "city", "San Leandro" ).
                log().all().
                when()
                .get( "{state}/{city}" ).
                then()
                .log().all()
                .statusCode( is( 200 ) )
                .contentType( ContentType.JSON )
                .body( "places[1][\"post code\"]", is( "94578" ) )
                .body( "country", is( "United States" ) )
                .body( "places[1].longitude", is( "-122.124" ) )
                .body( "state", is( "California" ) )
                .body( "places[1].'place name'", is( "San Leandro" ) )
                .body( "'country abbreviation'", is( "US" ) )
                .body( "places[-2].latitude", is( "37.7024" ) )


        ;


    }

}
