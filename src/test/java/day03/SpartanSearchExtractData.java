package day03;

import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static io.restassured.RestAssured.given;

public class SpartanSearchExtractData {
    @BeforeAll
    public static void SetUp(){
        RestAssured.baseURI = "http://54.89.28.41";
        RestAssured.port = 8000;
        RestAssured.basePath = "/api";
    }
    @Test
    public void test1(){
        Response response = given()
                .log().all()
                                  .queryParam( "gender","Female" )
                .when()
                       .get("/spartans/search")
                .prettyPeek()
                ;
        JsonPath jp = response.jsonPath();
        int numberOfElementSpartan = jp.getInt( "numberOfElements" );
        System.out.println("total element number : "+numberOfElementSpartan);
        List<Integer>numList=jp.getList( "content.id" );
        System.out.println("numlist : "+numList);
        List<String>nameList=jp.getList( "content.name" );
        System.out.println("nameList= "+nameList);
    }
}
