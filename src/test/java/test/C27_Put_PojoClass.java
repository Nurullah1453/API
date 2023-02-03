package test;

import baseURL.JsonPlaceHolderBaseUrl;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.junit.Assert;
import org.junit.Test;
import pojos.POJOJsonPlaceHolder;

import static io.restassured.RestAssured.given;

public class C27_Put_PojoClass extends JsonPlaceHolderBaseUrl {

    @Test
    public void put01(){

        /*
    C27_Put_PojoClass
 https://jsonplaceholder.typicode.com/posts/70 url'ine asagidaki
 body’e sahip bir PUT request yolladigimizda donen response’in
 response body’sinin asagida verilen ile ayni oldugunu test ediniz
     Request Body
    {
    "title":"Ahmet",
    "body":"Merhaba",
    "userId":10,
    "id":70
    }
    Expected Body
    {
    "title":"Ahmet",
    "body":"Merhaba",
    "userId":10,
    "id":70
    }
     */

        //1. Adim Url ve Body hazirlayalim
        specJsonPlace.pathParams("pp1","posts","pp2","70");

        POJOJsonPlaceHolder reqBody= new POJOJsonPlaceHolder("Ahmet","Merhaba",70,10);


        //2. Adim Expected Data hazirlayalim

        POJOJsonPlaceHolder expBody=new POJOJsonPlaceHolder("Ahmet","Merhaba",70,10);

        //3. Adim Response kaydedelim

        Response response=given().spec(specJsonPlace).contentType(ContentType.JSON)
                .when().body(reqBody).put("/{pp1}/{pp2}");

        //4. Adim Assertion
        POJOJsonPlaceHolder resPojo=response.as(POJOJsonPlaceHolder.class);

        Assert.assertEquals(expBody.getBody(),resPojo.getBody());
        Assert.assertEquals(expBody.getId(),resPojo.getId());
        Assert.assertEquals(expBody.getTitle(),resPojo.getTitle());
        Assert.assertEquals(expBody.getUserId(),resPojo.getUserId());


    }
}
