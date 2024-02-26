package api;

import io.restassured.RestAssured;
import org.junit.jupiter.api.Test;
import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class PostmanEchoTest
{
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
        String args = given()
                .baseUri("https://postman-echo.com")
                .when()
                .get("/get")
                .then()
                .extract()
                .path("args").toString();
        System.out.println(args);
        assertEquals("{}", args);
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
       String args = given()
               .baseUri("https://postman-echo.com")
               .body("foo").contentType("application/json")
               .when()
               .put("/put")
               .then()
               .extract()
               .path("args").toString();
       System.out.println(args);
       assertEquals("{}", args);
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
       String args = given()
               .baseUri("https://postman-echo.com")
               .body("foo").contentType("application/json")
               .when()
               .patch("/patch")
               .then()
               .extract()
               .path("args").toString();
       System.out.println(args);
       assertEquals("{}", args);
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
        String args = given()
                .baseUri("https://postman-echo.com")
                .body("foo").contentType("application/json")
                .when()
                .delete("/delete")
                .then()
                .extract()
                .path("args").toString();
        System.out.println(args);
        assertEquals("{}", args);
    }
}