package util;

import java.util.Map;

/**
 * Created by liupeng on 16/3/4.
 */
public class RespStatusUtil {
    public static Map<String,Object> success(Map<String,Object> map) {

        map.put("error", "0");
        map.put("status", "success");

        return map;
    }

    public static Map<String,Object> error(String emsg,Map<String,Object> map) {

        map.put("error", "1");
        map.put("status", "error");
        map.put("emsg",emsg);

        return map;
    }

}
