package util;

/**
 * Created by liupeng on 16/3/4.
 */
import java.util.Random;

public class RandomUtils {
    /*
     * 得到指定长度随机字符串
     * 2015-12-04 zfl
     */
    public static String getRandomString(int length) { //length表示生成字符串的长度
        String base = "abcdefghijklmnopqrstuvwxyz0123456789";
        Random random = new Random();
        StringBuffer sb = new StringBuffer();
        for (int i = 0; i < length; i++) {
            int number = random.nextInt(base.length());
            sb.append(base.charAt(number));
        }
        return sb.toString();
    }

}
