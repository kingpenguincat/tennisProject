package util;

import java.util.UUID;

/**
 * Created by liupeng on 16/3/5.
 */
public class Udid {

        public static String get32UUID() {
            String uuid = UUID.randomUUID().toString().trim().replaceAll("-", "");
            return uuid;
        }

}
