package day02;

import io.restassured.RestAssured;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.containsString;
import static org.hamcrest.Matchers.is;

public class movieSearch {
    @BeforeAll
    public static void init() {

        RestAssured.baseURI = "http://www.omdbapi.com";


    }
    @DisplayName( "open/db/api" )
    @Test
    public void movieSearch(){
        given().
                log().all()
                .queryParam("apikey" , "86b561b3")
                .queryParam("t","Recep İvedik")
                .queryParam("plot","full").
                when()
                .get().  // what if my URL is already complete , DO NOTHING
                then()
                .log().all()
                .statusCode(200)
                .body("Title" , containsString("Recep Ivedik") )
                .body("Ratings[0].Value" , is("4.6/10") )
                //.body("Ratings[2].Value" , is("82/100"))

                ;
    }
}
