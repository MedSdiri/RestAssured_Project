package spartan_util;

import com.github.javafaker.Faker;
import pojo.Spartan;

import java.util.LinkedHashMap;
import java.util.Map;

public class SpartanUtil {
 private static Faker faker = new Faker();
    /**
     * Used to get valid map object to represent post body fro POST/ spartans request
     * @return Map object with random name, gender, phone number(5000000000 - 100000000000)
     */
    public static Map<String, Object> getRandomSpartanMap(){

        Map<String,Object> bodyMap = new LinkedHashMap<>();
        bodyMap.put("name", faker.name().firstName()   );
        bodyMap.put("gender", faker.demographic().sex()  );
        bodyMap.put("phone", faker.number().numberBetween(5_000_000_000L, 10_000_000_000L) ) ;

        return bodyMap;
    }

    /***
     * Create random spartan Object with random field values
     * @return spartan object with random name, gender, phone number(5000000000 - 100000000000)
     */

    public static Spartan getRandomSpartanPOJO(){
        Spartan sp = new Spartan();

        sp.setName(faker.name().firstName());
        sp.setGender(faker.demographic().sex());
        sp.setPhone(faker.number().numberBetween(5_000_000_000L, 10_000_000_000L));

        return sp;
    }

}
