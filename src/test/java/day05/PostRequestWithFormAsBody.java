package day05;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.is;
import static org.hamcrest.Matchers.notNullValue;

public class PostRequestWithFormAsBody {

    //    http://library1.cybertekschool.com/rest/v1/login
    //    librarian69@library
    //    KNPXrm3S
    // HTTP--->80   PORT
    //HTTPS--->443  PORT
    // anything other than http or https we will mention
    @BeforeAll
    public static void SetUp() {
        RestAssured.baseURI = "http://library1.cybertekschool.com";
        RestAssured.basePath = "/rest/v1";
    }
    @DisplayName( "post / Login Request Test" )
    @Test
    public void testLoginEndPoint(){

        given()
                .log().all()
                .formParam( "email","librarian69@library" )
                .formParam( "password","KNPXrm3S" ).
        when()
                .post("/login").
        then()
                .log().all()
                .statusCode( 200 )
                .body( "token",is(notNullValue()) )

                ;
    }
    public static String loginAndGetToken(String username,String password){
        String token = "";

        Response response = given()
//                                .log().all()
                // explicitly saying the body content type is x-www-urlencoded-form-data
                .contentType(ContentType.URLENC)
                .formParam("email",username)
                .formParam("password", password ).
                        when()
                .post("/login") ;


        //token = response.path("token") ;  // this is using path method
        token = response.jsonPath().getString("token") ;
        return token ;
    }

}
