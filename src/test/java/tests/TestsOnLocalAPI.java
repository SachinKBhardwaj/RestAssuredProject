package tests;

import io.restassured.http.ContentType;
import org.json.simple.JSONObject;
import org.testng.annotations.Test;
import static io.restassured.RestAssured.*;

public class TestsOnLocalAPI {

    //@Test
    public void get(){
        baseURI = "http://localhost:3000/";
        given().get("/users").then().statusCode(200).log().all();

    }

    //@Test
    public void post(){
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("firstName", "Advika");
        jsonObject.put("lastName", "Bhardwaj");
        jsonObject.put("subjectId", 3);

        baseURI = "http://localhost:3000/";
        given()
                .contentType(ContentType.JSON)
                .accept(ContentType.JSON)
                .body(jsonObject.toJSONString())
                .when()
                        .post("/users")
                        .then()
                        .statusCode(201).log().all();


    }

    //@Test
    public void put(){
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("firstName", "Javedsdda");
        jsonObject.put("lastName", "Khsdatun");
        jsonObject.put("subjectId", 2);

        baseURI = "http://localhost:3000/";
        given()
                .contentType(ContentType.JSON)
                .accept(ContentType.JSON)
                .body(jsonObject.toJSONString())
                .when()
                .put("/users/4")
                .then()
                .statusCode(200).log().all();


    }

    //@Test
    public void patch(){
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("firstName", "Salman");

        baseURI = "http://localhost:3000/";
        given()
                .contentType(ContentType.JSON)
                .accept(ContentType.JSON)
                .body(jsonObject.toJSONString())
                .when()
                .patch("/users/4")
                .then()
                .statusCode(200).log().all();


    }

    @Test
    public void delete(){

        baseURI = "http://localhost:3000/";

                when()
                        .delete("/users/4").then().statusCode(200);



    }
}
