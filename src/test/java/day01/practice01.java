package day01;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.* ;
import static io.restassured.matcher.RestAssuredMatchers.* ;
import static org.hamcrest.Matchers.*;
public class practice01 {

    //http://52.71.242.164:8000/api/hello
    @Test
    public void test1(){
        //RestAssured.get("URL HERE")
        // SINCE WE DID THE STATIC IMPORT
        // we can directly call the get method
        // after we send the request
        // we can save the result in to a type called Response
        // need this  import io.restassured.response.Response;

        Response response = get("http://54.89.28.41:8000/api/hello");
        // response object store all the information aboutw the response we got
//        response code : 200
//        response line : HTTP/1.1 200
//        response header : Tue, 18 Aug 2020 16:49:12 GMT
//        response contentType : text/plain;charset=UTF-8
        int statuscode=response.statusCode();
        Assertions.assertEquals( 200,statuscode );

        String statusLine = response.statusLine();
        Assertions.assertEquals( "HTTP/1.1 200 " ,statusLine);

        String header= response.header("Date");
        Assertions.assertTrue( header.contains( "18 Aug 2020" ) );

        String contentType = response.contentType();
        Assertions.assertEquals( "text/plain;charset=UTF-8" ,contentType);

    }
    @DisplayName( "Testting / hello end point body" )
    @Test
    public void testtingHelloResponseBdoy(){

        Response response = get("http://54.89.28.41:8000/api/hello");

        System.out.println(response.asString());
        System.out.println(response.body().asString());
        Assertions.assertEquals( 17,response.asString().length() );
        Assertions.assertEquals( "Hello from Sparta",response.asString());
    }
    @DisplayName( "Printing the response body using method" )
    @Test
    public void printingBdoy(){
        Response response = get("http://54.89.28.41:8000/api/hello");

        response.prettyPrint();
        response.prettyPeek();
    }


}
