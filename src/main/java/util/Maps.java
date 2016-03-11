package util;

/**
 * Created by liupeng on 16/3/9.
 */
import java.text.DecimalFormat;

public class Maps {
    private static  double EARTH_RADIUS = 6378.137;//一般的认为，地球的赤道半径是6378137米

    private static double rad(double d)
    {
        return d * Math.PI / 180.0;
    }

    /**
     * 根据两点间经纬度坐标（double值），计算两点间距离，单位公里
     * @param lng1
     * @param lat1
     * @param lng2
     * @param lat2
     * @return
     */
    public static double getDistatce(double lng1, double lat1, double lng2, double lat2)
    {
		/* // 用户纬度的弧度
		 double radLat1 = rad(lat1);
		 // 酒店的纬度
		 double radLat2 = rad(lat2);
		 // 用户和酒店经度的弧度差
		 double a = radLat1 - radLat2;
		 double b = rad(lng1) - rad(lng2);
		 double s =
				 2 * Math.asin(
						 Math.sqrt(
								 Math.pow(Math.sin(a/2),2)
								+
								 Math.cos(radLat1)*Math.cos(radLat2)*Math.pow(Math.sin(b/2),2)
							 )
						 );
		 s = s * EARTH_RADIUS;
		 s = Math.round(s * 10000) /10000; //6730;
		 return s;*/

        double pk = 180 / Math.PI ;
        double a1 = lat1 / pk  ;
        double a2 = lng1 / pk  ;
        double b1 = lat2 / pk  ;
        double b2 = lng2 / pk  ;
        double t1 = Math.cos(a1) * Math.cos(a2) * Math.cos(b1) * Math.cos(b2) ;
        double t2 = Math.cos(a1) * Math.sin(a2) * Math.cos(b1) * Math.sin(b2)  ;
        double t3 = Math.sin(a1) * Math.sin(b1)  ;
        double tt = Math.acos(t1 + t2 + t3)  ;
        Double d=new Double(tt);
        if(d.isNaN()){
            System.out.println("经纬度报错");
            return getDistatce(lng1+0.00001,  lat1+0.00001,  lng2+0.00001,  lat2+0.00001);
        }else{
            DecimalFormat df=new DecimalFormat("0.00");
            // System.out.println("tt"+tt+"==============6371 * tt"+6371 * tt);
            d = new Double(6371 * tt);
            if(d.isNaN()){
                System.out.println("算出结果为NAN");
                getDistatce(lng1-0.00001,  lat1+0.00001,  lng2+0.00001,  lat2+0.00001);
            }
            return Double.parseDouble(df.format(6371 * tt));
        }
    }
    public static void main(String[] args) {
        //36.6807370000,117.1275270000
        //36.68699,117.1222
        //1068.51
        // beijing  39.9028076648,116.4011561818
        // shanghai 31.2323334171,121.4691573379
        System.out.println(Maps.getDistatce(36.66367,117.09784,36.66367,117.09784));
    }
}
