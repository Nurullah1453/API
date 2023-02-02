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

        //1.Adim URL ve gerekiyorsa Body olusturalim
        String url="http://dummy.restapiexample.com/api/v1/employee/3";

        //2.Adim Expected Data olusturalim
        JSONObject expectedInnerBody=new JSONObject();

        expectedInnerBody.put("id",3);
        expectedInnerBody.put("employee_name","Ashton Cox");
        expectedInnerBody.put("employee_salary",86000);
        expectedInnerBody.put("employee_age",66);
        expectedInnerBody.put("profile_image","");

        JSONObject expectedBody=new JSONObject();

        expectedBody.put("status","success");
        expectedBody.put("data",expectedInnerBody);
        expectedBody.put("message","Successfully! Record has been fetched.");

        //3.Adim Response kaydedelim
        Response response=given().when().get(url);

        //4.Adim Assertion
        SoftAssert softAssert=new SoftAssert();
        JsonPath resJPath=response.jsonPath();

        softAssert.assertEquals(resJPath.get("status"),expectedBody.get("status"));
        softAssert.assertEquals(resJPath.get("message"),expectedBody.get("message"));
        softAssert.assertEquals(resJPath.get("data.id"),expectedBody.getJSONObject("data").get("id"));
        softAssert.assertEquals(resJPath.get("data.employee_name"),expectedBody.getJSONObject("data").get("employee_name"));
        softAssert.assertEquals(resJPath.get("data.employee_age"),expectedBody.getJSONObject("data").get("employee_age"));
        softAssert.assertEquals(resJPath.get("data.profile_image"),expectedBody.getJSONObject("data").get("profile_image"));


        softAssert.assertAll();


    }
}
