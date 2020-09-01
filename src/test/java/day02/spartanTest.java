package day02;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static io.restassured.RestAssured.* ;
import static io.restassured.matcher.RestAssuredMatchers.* ;
import static org.hamcrest.Matchers.*;

public class spartanTest extends baseUrl{
    @DisplayName( "get all spartan" )
    @Test
    public void spartanTest(){
//        //String spartanurl = "http://54.89.28.41:8000/api/spartans";
//        RestAssured.baseURI = "http://54.89.28.41:8000";
//        RestAssured.basePath = "/api";
given()
        .header( "Accept","application/json" ).
        when()
                .get("/spartans").
                prettyPeek().
                then()
                .statusCode( is(200) )
                //.header("Content-Type", is("application/json; charset=utf-8") )
        ;

    }
    @DisplayName( "get all spartan02" )
    @Test
    public void spartanTest02(){
//       given()
//               .baseUri( "http://54.89.28.41:8000" )
//               .basePath( "/api" )
//               .accept( ContentType.JSON ).
       when()
               .get("/spartans").
       then()
               .statusCode( is( 200 ) ).
               contentType( ContentType.JSON );

    }
    @DisplayName( "get all spartan003" )
    @Test
    public void spartanTest03(){
        given()
//                .baseUri( "http://54.89.28.41:8000" )
//                .basePath( "/api" )
                .accept( ContentType.JSON ).
                when()
                .get("/spartans").
                then()
                .statusCode( is( 200 ) ).
                contentType( ContentType.JSON );

    }


}
