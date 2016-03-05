package util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;

/**
 * Created by liupeng on 16/3/4.
 */
public class Utils {

    /**
     * @author yh
     * time : 2014-9-26
     * content : 生成随机四位数验证码
     * @return
     */
    public static String getRandom(){
        // 生成四位数验证码
        String sRand = "";
        Random random = new Random();
        for (int i = 0; i < 4; i++) {
            String rand = String.valueOf(random.nextInt(10));
            sRand += rand;
        }
        return sRand;
    }

    /**
     * @author qxj
     * time : 2015-3-19
     * content : 生成随机6位数
     * @return
     * */
    public static String getSixRandom(){
        // 生成四位数验证码
        String sRand = "";
        Random random = new Random();
        for (int i = 0; i < 6; i++) {
            String rand = String.valueOf(random.nextInt(10));
            sRand += rand;
        }
        return sRand;
    }


    public static int string2Time(String time){
        SimpleDateFormat simpleDateFormat =new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Date date;
        int timeStemp = 0;
        try {
            date = simpleDateFormat.parse(time);

            timeStemp = (int)(date.getTime()/1000);

        } catch (ParseException e) {
            e.printStackTrace();
        }
        return timeStemp;
    }

}

