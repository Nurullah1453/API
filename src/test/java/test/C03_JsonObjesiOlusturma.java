package test;

import org.json.JSONObject;
import org.junit.Test;

public class C03_JsonObjesiOlusturma {

    @Test
    public void jsonObje01(){

         /*
    Asagidaki JSON Objesini olusturup konsolda yazdirin.
    {
        "title":"Ahmet",
        "body":"Merhaba",
        "userId":1
    }
*/
        JSONObject ilkJsonObje=new JSONObject();
        ilkJsonObje.put("title","Ahmet")
                .put("body","Merhaba")
                .put("userId",1);
        System.out.println(ilkJsonObje.toString());
    }

    @Test
    public void jsonObje02(){
        /*
                {
                 "firstname":"Jim",
                 "additionalneeds":"Breakfast",
                 "bookingdates":{
                         "checkin":"2018-01-01",
                         "checkout":"2019-01-01"
                    },
                  "totalprice":111,
                  "depositpaid":true,
                  "lastname":"Brown"
                  }
         */

        JSONObject innerBody=new JSONObject();

        innerBody.put("checkin","2018-01-01")
                .put("checkout","2019-01-01");

        JSONObject reqBody=new JSONObject();
        reqBody.put("firstname","Jim")
                .put("additionalneeds","Breakfast")
                .put("bookingdates",innerBody)
                .put("totalprice",111)
                .put("depositpaid",true)
                .put("lastname","Brown");

        System.out.println(reqBody.toString());
    }

}
