package day03;

import io.restassured.response.Response;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;

public class extractingDataOutOfResponseBody {

    @DisplayName("Getting Movie info")
    @Test
    public void test1() {
        Response response =
                given()
                        .log().all()
                        .baseUri( "http://www.omdbapi.com" )
                        .queryParam( "apikey", "86b561b3" )
                        .queryParam( "t", "Boss Baby" ).
                        when()
                        .get();

        response.prettyPrint();
        System.out.println(response.statusCode());
        String title = response.path( "Title" );
        System.out.println("title = "+title);
        String year=response.path("movie release year = "+"Year");
        System.out.println(year);
        String director=response.path("Director");
        System.out.println("Director is = "+director);
    }
}
