package test;

import io.restassured.http.ContentType;
import io.restassured.response.Response;
import netscape.javascript.JSObject;
import org.hamcrest.Matchers;
import org.json.JSONObject;
import org.junit.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.*;
import static org.hamcrest.Matchers.lessThan;

public class C06_Post_ResponseBodyTesi {
    /*  https://jsonplaceholder.typicode.com/posts
         url’ine asagidaki body ile bir POST request gonderdigimizde
        {
        "title":"API",
        "body":"API ogrenmek ne guzel",
        "userId":10,
        }
        donen Response’un,
        status code’unun 201,
        ve content type’inin application/json
        ve Response Body'sindeki,
        "title"'in "API" oldugunu
        "userId" degerinin 100'den kucuk oldugunu
        "body" nin "API" kelimesi icerdigini
        test edin.
      */

    @Test
    public void post01(){

        //1. Adim URL ve gerekiyorsa Body hazirlayalim
        String url="https://jsonplaceholder.typicode.com/posts";

        JSONObject reqBody=new JSONObject();
        reqBody.put("title","API")
                .put("body","API ogrenmek ne guzel")
                .put("userId",10);

        //2. Adim Expected Data hazirlayalim
        //(Bu testimizde gerekmedigi icin bu adimi atliyoruz)

        //3.Response kaydedelim
        Response response=given().contentType(ContentType.JSON)
                .when().body(reqBody.toString()).post(url);

        //4. Adim Assertion
        response.then().assertThat()
                .statusCode(201)
                .contentType(ContentType.JSON)
                .body("title",Matchers.equalTo("API"))
                .body("userId", lessThan(100))
                .body(Matchers.containsString("API"));

    }

    @Test
    public void post02(){

        //1. Adim URL ve gerekiyorsa Body hazirlayalim
        String url="https://jsonplaceholder.typicode.com/posts";

        JSONObject reqBody=new JSONObject();

        reqBody.put("title","API");
        reqBody.put("body","API ogrenmek ne guzel");
        reqBody.put("userId",10);

        //2. Adim Expected Data hazirlayalim
        //(Bu testimizde gerekmedigi icin bu adimi atliyoruz)

        //3.Response kaydedelim
        Response response=given()
                .contentType(ContentType.JSON)

                .when().body(reqBody.toString())
                .post(url);

        //4. Adim Assertion
        response.
                then().
                assertThat().
                statusCode(201).
                contentType("application/json").
                body("title",equalTo("API"),
                        "userId",lessThan(100),
                        "body",containsString("API"));
    }
}
