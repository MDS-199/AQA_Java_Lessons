package api;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import org.junit.jupiter.api.Test;
import org.json.JSONObject;
import static io.restassured.path.json.JsonPath.*;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class PostmanEchoTest
{
    String getExpectedBody = ExpectedBody.getExpectedBody;
 @Test
    public void checkGetOutputStatus(){
        given()
                .baseUri("https://postman-echo.com")
                .when()
                .get("/get")
                .then()
                .assertThat()
                .statusCode(200);
    }
    @Test
    public void checkGetOutputBody(){
        RestAssured.baseURI = "https://postman-echo.com";
        given()
            .when()
            .get("/get")
            .then()
            .statusCode(200)
            .assertThat()
            .body("data", equalTo(null));
        //String responseBodyWithoutIdCookie = with(responseBody).delete("id").get().toString();
        //assertEquals(getExpectedBody, responseBody);
    }
    @Test
    public void checkPostStatus(){
        given()
                .baseUri("https://postman-echo.com")
                .body("foo").contentType("application/json")
                .when()
                .post("/post")
                .then()
                .statusCode(200);
    }
    @Test
    public void checkPostDataOutput(){
        given()
                .baseUri("https://postman-echo.com")
                .body("foo").contentType("application/json")
                .when()
                .post("/post")
                .then()
                .statusCode(200)
                .assertThat()
                .body("data", equalTo("foo"));
    }
    @Test
    public void checkPutStatus(){
        given()
                .baseUri("https://postman-echo.com")
                .when()
                .put("/put")
                .then()
                .assertThat()
                .statusCode(200);
    }
   @Test
    public void checkPutDataOutput(){
        given()
                .baseUri("https://postman-echo.com")
                .body("foo").contentType("application/json")
                .when()
                .put("/put")
                .then()
                .assertThat()
                .body("data", equalTo("foo"));
    }
    @Test
    public void checkPatchStatus(){
        given()
                .baseUri("https://postman-echo.com")
                .when()
                .patch("/patch")
                .then()
                .assertThat()
                .statusCode(200);
    }
   @Test
    public void checkPatchDataOutput(){
        given()
                .baseUri("https://postman-echo.com")
                .body("foo").contentType("application/json")
                .when()
                .patch("/patch")
                .then()
                .assertThat()
                .body("data", equalTo("foo"));
    }
    @Test
    public void checkDeleteStatus(){
        given()
                .baseUri("https://postman-echo.com")
                .when()
                .delete("/delete")
                .then()
                .assertThat()
                .statusCode(200);
    }
    @Test
    public void checkDeleteDataOutput(){
        given()
                .baseUri("https://postman-echo.com")
                .body("foo").contentType("application/json")
                .when()
                .delete("/delete")
                .then()
                .assertThat()
                .body("data", equalTo("foo"));
    }
}