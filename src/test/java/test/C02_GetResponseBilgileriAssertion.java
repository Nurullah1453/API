package test;

import io.restassured.response.Response;
import org.junit.Test;

import static io.restassured.RestAssured.given;

public class C02_GetResponseBilgileriAssertion {
    /*
        https://restful-booker.herokuapp.com/booking/69 url’ine bir GET request
        gonderdigimizde donen Response’un,
        status code’unun 200,
        ve content type’inin application/json; charset=utf-8,
        ve Server isimli Header’in degerinin Cowboy,
        ve status Line’in HTTP/1.1 200 OK
        oldugunu test edin.
         */

    @Test
    public void get02(){

        //1.Adim URL ve lazim ise body hazirlayalim      (Get methodu oldugu icin body ihtiyacimiz yok)
        String url="https://restful-booker.herokuapp.com/booking/69";

        //2.Adim Expected Data hazirlayalim (Bu test icin bu adima ihtiyacimiz yok)

        //3.Adim Response kaydedelim
        Response response=given().when().get(url);

        //4.Adim Assertion yapalim
        response.then().assertThat()
                .statusCode(200)
                .contentType("application/json; charset=utf-8")
                .header("Server","Cowboy")
                .statusLine("HTTP/1.1 200 OK");
    }

}
