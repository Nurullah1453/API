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

        //1-Gonderecegimiz Request icin gerekli olan URL ve ihtiyacımız varsa body'i hazırlayalim.
        String url="https://restful-booker.herokuapp.com/booking/69";

        //2-Eger soruda bize verilmisse Expected Data hazırlayalim

        //3-Bize donen Response'i Actual Data olarak kaydedelim
        Response response=given().when().get(url);

        //4-Expected Data ile Actual Data'nin karsilastirilmasini yapalım (Assertion)

        response.then()
                .assertThat()
                .statusCode(200)
                .contentType("application/json; charset=utf-8")
                .header("Server","Cowboy")
                .statusLine("HTTP/1.1 200 OK");

    }
}
