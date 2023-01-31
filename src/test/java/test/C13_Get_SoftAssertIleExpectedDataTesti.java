package test;

import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.json.JSONObject;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import static io.restassured.RestAssured.given;

public class C13_Get_SoftAssertIleExpectedDataTesti {
    /*
    http://dummy.restapiexample.com/api/v1/employee/3 url’ine bir GET request
    gonderdigimizde donen response’un asagidaki gibi oldugunu test edin.
        Response Body
        {
        "status":"success",
        "data":{
                "id":3,
                "employee_name":"Ashton Cox",
                "employee_salary":86000,
                "employee_age":66,
                "profile_image":""
                },
        "message":"Successfully! Record has been fetched."
        }
     */

    @Test
    public void get01(){

        //Url hazirla
        String url="http://dummy.restapiexample.com/api/v1/employee/3";

        //Expected Data hazirla
        JSONObject innerBody=new JSONObject();

        innerBody.put("id",3);
        innerBody.put("employee_name","Ashton Cox");
        innerBody.put("employee_salary",86000);
        innerBody.put("employee_age",66);
        innerBody.put("profile_image","");

        JSONObject expectedBody=new JSONObject();

        expectedBody.put("status","success");
        expectedBody.put("message","Successfully! Record has been fetched.");
        expectedBody.put("data",innerBody);

        //Response kaydet
        Response response=given().when().get(url);

        //Assertion
        SoftAssert softAssert=new SoftAssert();

        JsonPath resJPath=response.jsonPath();

        softAssert.assertEquals(resJPath.get("status"),expectedBody.get("status"));
        softAssert.assertEquals(resJPath.get("message"),expectedBody.get("message"));
        softAssert.assertEquals(resJPath.get("data.id"),expectedBody.getJSONObject("data").get("id"));
        softAssert.assertEquals(resJPath.get("data.employee_name"),expectedBody.getJSONObject("data").get("employee_name"));
        softAssert.assertEquals(resJPath.get("data.employee_salary"),expectedBody.getJSONObject("data").get("employee_salary"));
        softAssert.assertEquals(resJPath.get("data.employee_age"),expectedBody.getJSONObject("data").get("employee_age"));
        softAssert.assertEquals(resJPath.get("data.profile_image"),expectedBody.getJSONObject("data").get("profile_image"));

        softAssert.assertAll();


    }
}
