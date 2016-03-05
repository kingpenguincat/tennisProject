package util;

/**
 * Created by liupeng on 16/3/4.
 */
import java.util.ArrayList;
import java.util.List;

/*
 * 发送短信线程
 * 使用方法
 * Thread sendthread = new SendMassageThread("15854163460","您正在重置密码，验证码为【1414】，验证码10分钟内有效。",0);
 *   sendthread.run();
 *   2015-12-04 zfl
 */
public class SendMessageThread extends Thread{
    public String phone="";
    public String content="";
    public Integer type=0;
    public SendMessageThread(String phone,String content,Integer type) {
        super(RandomUtils.getRandomString(6));
        this.content=content;
        this.phone=phone;
        this.type=type;
    }

    public void run() {
        System.out.println("发送短信线程启动"+Thread.currentThread().getName()+System.currentTimeMillis());
        boolean isSecusses=false;int i=0;
        do{
            isSecusses=GeneralSendSMSUtil.sendMsg(this.phone, this.content, this.type,true);
            i++;
            System.out.println(this.phone+"短信发送次数"+i);

            try {
                if(!isSecusses){
                    Thread.currentThread().sleep(60000);
                }
            } catch (InterruptedException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }while(!isSecusses&&i<3);
        System.out.println("发送短信线程结束"+Thread.currentThread().getName()+System.currentTimeMillis());
    }
}

