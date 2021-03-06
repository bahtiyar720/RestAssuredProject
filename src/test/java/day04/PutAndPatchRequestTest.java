package day04;

import com.github.javafaker.Faker;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import pojo.Spartan;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

import static io.restassured.RestAssured.given;
import static io.restassured.RestAssured.when;
import static org.hamcrest.Matchers.is;

public class PutAndPatchRequestTest {
    @BeforeAll
    public static void SetUp(){
        RestAssured.baseURI = "http://54.89.28.41";
        RestAssured.port = 8000;
        RestAssured.basePath = "/api";
    }
    @DisplayName("Put Request body as a Map")
    @Test
    public void testPutRequestWithMap() {

        // put request to update spartan with id 421
        // name : put with map  , gender : Male , phone : 1231231234
        // status code 204
        // how do I actually know it's updated since it does not have body in request
        // we can make another get request right after this and assert the body
        // getting random name
        String randomName = new Faker().name().firstName();

        Map<String,Object> updatedBody = new LinkedHashMap<>();
        updatedBody.put("name", randomName) ;
        updatedBody.put("gender", "Male") ;
        updatedBody.put("phone",8745124312L ) ;

        given()
                .log().all()
                .contentType(ContentType.JSON)
                .body(updatedBody). // this is how we do it with the map
                when()
                .put("/spartans/{id}",142).
                then()
                .log().all()
                .statusCode( is(204) )
        ;
        //  MAKING ANOTHER GET REQUEST TO MAKE SURE IT WORKED !!!!!

        when()
                .get("/spartans/{id}",142).
                then()
                .statusCode(200)
                .body("name" , is(randomName ) )
        ;



    }


    @DisplayName("Put Request body as a POJO")
    @Test
    public void testPutRequestWithPojo() {

        // put request to update spartan with id 421
        // name : put with map  , gender : Male , phone : 1231231234
        // status code 204
        // how do I actually know it's updated since it does not have body in request
        // we can make another get request right after this and assert the body
        // getting random name
        String randomName = new Faker().name().firstName();

        // This is how we can provide POJO instead
        Spartan sp1 = new Spartan( randomName , "Female" , 1231231231L ) ;

        given()
                .log().all()
                .contentType(ContentType.JSON)
                //.body(updatedBody). // this is how we do it with the map
                .body(sp1).
                when()
                .put("/spartans/{id}",142).
                then()
                .log().all()
                .statusCode( is(204) )
        ;

    }

    @DisplayName("Patch request ")
    @Test
    public void testPathPartialUpdate(){

        // ONLY UPDATE THE NAME WITH FAKER
        String randomName = new Faker().name().firstName();
//        String patchBody = "\"name\" : \" "+ randomName + "\" " ;
        Map<String, Object> patchBodyMap = new HashMap<>();
        patchBodyMap.put("name" , randomName) ;

        given()
                .log().all()
                .contentType(ContentType.JSON)
                .body(patchBodyMap).
                when()
                .patch("/spartans/{id}" , 142).
                then()
                .log().all()
                .statusCode(204) ;


    }


}
