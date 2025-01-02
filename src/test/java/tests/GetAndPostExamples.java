package tests;

import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import java.util.HashMap;
import java.util.Map;

import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;


public class GetAndPostExamples {

    @Test
    public void testGet(){
        baseURI = "https://reqres.in/api";
        given().
                get("/users?page=2").
                then().
                statusCode(200).body("data[4].first_name", equalTo("George"));
    }

    @Test
    public void testPost(){
        Map<String,Object> map= new HashMap<String, Object>();
        map.put("name","sachin");
        map.put("profession","hustler");
        System.out.println(map);
        JSONObject jsonObject = new JSONObject(map);
        System.out.println(jsonObject);
        baseURI = "https://reqres.in/api";
        given().
                body(jsonObject.toJSONString())
                .when().
                post("/users").
                then().
                statusCode(201).log().all();

    }
}
