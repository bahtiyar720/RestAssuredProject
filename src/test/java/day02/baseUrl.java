package day02;

import io.restassured.RestAssured;
import org.junit.jupiter.api.BeforeAll;

import static io.restassured.RestAssured.*;
import static io.restassured.RestAssured.given;

public abstract class baseUrl {

    @BeforeAll
    public static void setUp() {

                RestAssured.baseURI= "http://54.89.28.41:8000";
                RestAssured.basePath= "/api" ;
    }


}