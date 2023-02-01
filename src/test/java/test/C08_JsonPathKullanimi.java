package test;

import org.json.JSONArray;
import org.json.JSONObject;
import org.junit.Test;

public class C08_JsonPathKullanimi {

    @Test
    public void path(){

        JSONObject kisiBilgisi=new JSONObject();
        JSONObject adresBilgisi=new JSONObject();
        JSONObject cepTelefonu=new JSONObject();
        JSONObject evTel=new JSONObject();
        JSONArray telBilgileri=new JSONArray();

        cepTelefonu.put("type","iPhone");
        cepTelefonu.put("number","0123-4567-8888");
        evTel.put("type","home");
        evTel.put("number","0123-4567-8910");

        telBilgileri.put(evTel);
        telBilgileri.put(cepTelefonu);

        adresBilgisi.put("streetAddress","naist street");
        adresBilgisi.put("city","Nara");
        adresBilgisi.put("postalCode","630-0192");

        kisiBilgisi.put("firstName","John");
        kisiBilgisi.put("lastName","doe");
        kisiBilgisi.put("age",26);
        kisiBilgisi.put("adress",adresBilgisi);
        kisiBilgisi.put("phoneNumbers",telBilgileri);

        System.out.println(kisiBilgisi);


    }
}
