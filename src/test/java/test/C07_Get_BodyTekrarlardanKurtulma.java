package test;

import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.hamcrest.Matchers;
import org.junit.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.equalTo;

public class C07_Get_BodyTekrarlardanKurtulma {

     /*
        https://restful-booker.herokuapp.com/booking/10 url’ine bir GET request
        gonderdigimizde donen Response’un,
        status code’unun 200,
        ve content type’inin application-json
        ve response body'sindeki
        "firstname"in,"Mark",
        "lastname"in,"Smith",
        "totalprice"in,205,
        "depositpaid'in false,
         "additionalneeds"in "Breakfast"

        oldugunu test edin
         */

    @Test
    public void get01(){

        //1.Adim URL ve gerekiyorsa Body hazirliyalim

        String url="https://restful-booker.herokuapp.com/booking/10";

        //2.Testimizde isteniyorsa Expected Data hazirlayalim
        //(Bu testimizde gerekmedigi icin bu adimi geçiyoruz)

        //3.Adim response kaydedelim
        Response response=given().when().get(url);


        //4. Adim Assertion
        response.then().assertThat()
                .statusCode(200)
                .contentType(ContentType.JSON)
                .body("firstname",equalTo("Mark"),
                        "lastname",equalTo("Smith"),
                        "totalprice",equalTo(205),
                        "depositpaid",equalTo(false),
                        "additionalneeds",equalTo("Breakfast"));

    }
}
