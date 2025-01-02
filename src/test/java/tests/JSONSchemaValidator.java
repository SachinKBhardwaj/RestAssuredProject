package tests;

import org.testng.annotations.Test;

import static io.restassured.RestAssured.*;
import static org.hamcrest.Matcher.*;
import static org.hamcrest.Matchers.hasItems;
import static io.restassured.module.jsv.JsonSchemaValidator.matchesJsonSchemaInClasspath;

public class JSONSchemaValidator {

    @Test
    public void testGet(){
        baseURI = "https://reqres.in/api";
        given().
                get("/users?page=2").
                then().
                assertThat().body(matchesJsonSchemaInClasspath("schema.json")).
                statusCode(200);
    }
}
