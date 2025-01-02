package tests;

import io.restassured.http.ContentType;
import static io.restassured.matcher.RestAssuredMatchers.matchesXsdInClasspath;
import org.apache.commons.io.IOUtils;
import org.testng.annotations.Test;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

import static io.restassured.RestAssured.baseURI;
import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

public class XSDSchemaValidation {

    @Test
    public void validateXSDSchema() throws IOException {
        File file = new File(".\\target\\classes\\Add.xml");
        if (file.exists()){
            System.out.println("File exists");
        }
        FileInputStream fis = new FileInputStream(file);
        String requestBody = IOUtils.toString(fis,"UTF-8");

        baseURI = "http://www.dneonline.com";
        given().
                contentType("text/xml").
                accept(ContentType.XML).
                body(requestBody).
                when().
                post("/calculator.asmx").
                then().
                statusCode(200).
                log().
                all().
                and().body("//*:AddResult.text()",equalTo("10")).
                and().
                assertThat().body(matchesXsdInClasspath("Calculator.xsd"));
    }
}
