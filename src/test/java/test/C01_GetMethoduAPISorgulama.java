package test;

import io.restassured.response.Response;
import org.junit.Assert;
import org.junit.Test;

import static io.restassured.RestAssured.given;

public class C01_GetMethoduAPISorgulama {

    /*
        https://restful-booker.herokuapp.com/booking/2231 url’ine
        bir GET request gonderdigimizde donen Response’un,
        status code’unun 200,
        ve content type’inin application/json; charset=utf-8,
        ve Server isimli Header’in degerinin Cowboy,
        ve status Line’in HTTP/1.1 200 OK
        ve response suresinin 5 sn’den kisa oldugunu manuel olarak test ediniz.
         */

    @Test
    public void get01() {

        //1.Adım Url ve ihtiyac varsa body hazirlayalim (Bu test icin get oldugu icin body ihtiyaci yok)
        String url="https://restful-booker.herokuapp.com/booking/2231";

        //2.Adım Expected Data hazirlayalim (Bu soru icin ihtiyacimiz yok)

        //3.Adım Response Actual Data olarak kaydedelim
        Response response=given().when().get(url);

        System.out.println("Status Code: " + response.getStatusCode());
        System.out.println("Content Type: " + response.getContentType());
        System.out.println("Server: " + response.getHeader("Server"));
        System.out.println("Status Line: " + response.getStatusLine());
        System.out.println("Suresi: " + response.getTime());


        //4.Adim karsilastirma (Assertion) yapalim (Bu test icin manuel denildigi icin bu adamı yapmayacagız)

    }


}
