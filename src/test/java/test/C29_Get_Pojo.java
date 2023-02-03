package test;

import baseURL.DummyBaseURL;
import io.restassured.response.Response;
import org.junit.Assert;
import org.junit.Test;
import pojos.PojoDummyData;
import pojos.PojoDummyExpectedBody;

import static io.restassured.RestAssured.given;
import static org.junit.Assert.assertEquals;

public class C29_Get_Pojo extends DummyBaseURL {
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
    "message":"Successfully!Record has been fetched."
    }
     */

    @Test
    public void get01(){

        //1.Adim Url hazirlayalim
        specDummy.pathParams("pp1","employee","pp2",3);


        //2.Adim Expected Data Hazirlayalim
        PojoDummyData data=new PojoDummyData(3,"Ashton Cox",86000,66,"");

        PojoDummyExpectedBody expBody=new PojoDummyExpectedBody("success",data,"Successfully! Record has been fetched.");

        //3.Adim Response kaydedelim
        Response response=given().spec(specDummy).when().get("/{pp1}/{pp2}");

        //4.Adim Assertion
        PojoDummyExpectedBody resPojo=response.as(PojoDummyExpectedBody.class);

        assertEquals(expBody.getStatus(),resPojo.getStatus());
        assertEquals(expBody.getMessage(),resPojo.getMessage());
        assertEquals(expBody.getData().getEmployee_age(),resPojo.getData().getEmployee_age());
        assertEquals(expBody.getData().getId(),resPojo.getData().getId());
        assertEquals(expBody.getData().getProfile_image(),resPojo.getData().getProfile_image());
        assertEquals(expBody.getData().getEmployee_salary(),resPojo.getData().getEmployee_salary());
        assertEquals(expBody.getData().getEmployee_name(),resPojo.getData().getEmployee_name());







    }
}
