package util;




import org.apache.commons.httpclient.HttpClient;
import org.apache.commons.httpclient.HttpException;
import org.apache.commons.httpclient.NameValuePair;
import org.apache.commons.httpclient.methods.PostMethod;
import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.DocumentHelper;
import org.dom4j.Element;

import java.io.IOException;

/**
 * Created by liupeng on 16/3/4.
 */
public class GeneralSendSMSUtil {

        private static String Url = "http://106.ihuyi.cn/webservice/sms.php?method=Submit";

    public static boolean sendMsg(String phone, String content, int type,boolean getrturn) {

        HttpClient client = new HttpClient();
        PostMethod method = new PostMethod(Url);
        client.getParams().setContentCharset("UTF-8");
        method.setRequestHeader("ContentType",
                "application/x-www-form-urlencoded;charset=UTF-8");


        NameValuePair[] data = {// 提交短信
                new NameValuePair("account", "cf_enterprise"),
                new NameValuePair("password", "123456"),
                new NameValuePair("mobile", phone),
                new NameValuePair("content", content), };
        method.setRequestBody(data);


        try {
            client.executeMethod(method);

            String SubmitResult = method.getResponseBodyAsString();

            // System.out.println(SubmitResult);

            Document doc = DocumentHelper.parseText(SubmitResult);
            Element root = doc.getRootElement();

            String code = root.elementText("code");
            String msg = root.elementText("msg");
            String smsid = root.elementText("smsid");

            System.out.println(code);
            System.out.println(msg);
            System.out.println(smsid);

            if (code == "2") {
                System.out.println("短信提交成功");
                return true;
            }else{
                System.out.println("发短信错误代码"+code);
                //返回false需要重新发送
                //* 0    提交失败 4080.同一手机号码同一秒钟不能超过2条
                if(code.equals("0")){
                    return false;
                }
                if(code.equals("4080")){
                    return false;
                }
                return true;
            }

        } catch (HttpException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();

        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();

        } catch (DocumentException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();

        }
        return false;
    }
}
