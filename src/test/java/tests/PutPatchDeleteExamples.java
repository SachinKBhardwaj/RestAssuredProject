package tests;

import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import java.util.HashMap;
import java.util.Map;

import static io.restassured.RestAssured.*;

public class PutPatchDeleteExamples {

    //@Test
    public void testPut(){
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
                put("/users/2").
                then().
                statusCode(200).log().all();

    }

    //@Test
    public void testPatch(){
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
                patch("/users/2").
                then().
                statusCode(200).log().all();

    }

    @Test
    public void testDelete(){
        baseURI = "https://reqres.in/api";
        when().
                delete("/users/2").
                then().
                statusCode(204).log().all();

    }
}
