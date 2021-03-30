package spartan_util;

import java.util.LinkedHashMap;
import java.util.Map;

public class SpartanUtil {

    /**
     * Used to get valid map object to represent post body fro POST/ spartans request
     * @return Map object with random name, gender, phone number
     */
    public static Map<String, Object> getRandomSpartanMap(){
        Map<String, Object> bodyMap = new LinkedHashMap<>();
        bodyMap.put("name", "Shannon");
        bodyMap.put("gender", "Female");
        bodyMap.put("phone", 1800233232L);

        return bodyMap;
    }

}
