package test;

import baseURL.HerokuappBaseUrl;
import io.restassured.response.Response;
import org.hamcrest.Matchers;
import org.junit.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.*;

public class C17_BaseUrlHerokuappQueryParam extends HerokuappBaseUrl {

    // Class icinde 3 Test metodu olusturun ve asagidaki testleri yapin

    @Test
    public void get01(){

         /*
        1-  https://restful-booker.herokuapp.com/booking endpointine bir GET
        request gonderdigimizde donen response’un status code’unun 200 oldugunu
        ve Response’ta 2789 id'ye sahip bir booking oldugunu test edin
     */

        //1-Url hazirla
        specHerokuapp.pathParam("pp1","booking");

        //2-Expected Data hazirlayalim

        //3-Response kaydedelim
        Response response=given().spec(specHerokuapp).when().get("/{pp1}");

        //4-Assertion
        response.then().assertThat()
                .statusCode(200)
                .body("bookingid",Matchers.hasItem(2789));
    }

    @Test
    public void get02(){
 /*
        2- https://restful-booker.herokuapp.com/booking endpointine gerekli
        Query parametrelerini yazarak “firstname” degeri “Eric” olan rezervasyon
        oldugunu test edecek bir GET request gonderdigimizde, donen response’un
        status code’unun 200 oldugunu ve “Eric” ismine sahip en az bir booking oldugunu test edin
    */

        //1.Adim Url hazirlayalim
        specHerokuapp.pathParam("pp1","booking").queryParam("firstname","Eric");

        //2.Adim Expected Data hazirlayalim

        //3.Adim Response kaydedelim
        Response response=given().spec(specHerokuapp).when().get("/{pp1}");

        //4.Adim Assertion
        response.then().assertThat()
                .statusCode(200)
                .body("bookingid", hasSize(1));
    }

    @Test
    public void get03(){

         /*
        3- https://restful-booker.herokuapp.com/booking endpointine gerekli Query
         parametrelerini yazarak “firstname” degeri “Jim” ve “lastname” degeri
         “Jackson” olan rezervasyon oldugunu test edecek bir GET request gonderdigimizde,
         donen response’un status code’unun 200 oldugunu ve “Jim Jackson” ismine sahip
         en az bir booking oldugunu test edin.
    */

        //1.Adim Url hazirlayalim
        specHerokuapp.pathParam("pp1","booking").queryParams("firstname","Jim","lastname","Jackson");

        //2.Adim Expected Data olusturalim

        //3.Adim Response kaydedelim
        Response response=given().spec(specHerokuapp).when().get("/{pp1}");

        //4.Adim Assertion
        response.then().assertThat()
                .statusCode(200)
                .body("bookingid",hasSize(1));


    }
}
