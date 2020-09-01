package day04;
import com.github.javafaker.Faker;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import pojo.Spartan;

import java.io.File;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;

public class PostRequestWithPOJO {
    @BeforeAll
    public static void SetUp(){
        RestAssured.baseURI = "http://54.89.28.41";
        RestAssured.port = 8000;
        RestAssured.basePath = "/api";
    }
    @Test
    public void testPostBodyWithPojo() {

        Spartan sp1 = new Spartan("Irina Li", "Female",1231231231 ) ;

        given()
                .log().all()
                .contentType(ContentType.JSON)
                .body(sp1).
                when()
                .post("/spartans").
                then()
                .log().all()
                .statusCode(201) ;
        // BACK ON 4:01 PM EST



    }


}
