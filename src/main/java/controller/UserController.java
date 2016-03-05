package controller;

import bean.User;
import form.UserForm;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import service.AppUserService;
import util.RespStatusUtil;
import util.SMSUtils;
import util.SendMessageThread;
import util.Udid;

import java.util.*;

/**
 * Created by liupeng on 16/3/4.
 */
@Controller
public class UserController {
    @Autowired
    private AppUserService appUserService;
    private Log logger = LogFactory.getLog(this.getClass());
    @RequestMapping("/appUser/getCode")
    @ResponseBody
    public Map getCode(UserForm userForm) {
        Map map = new HashMap();
        String phone = userForm.getPhone();
        try {
            //String code = Sendsms.sendMsg(phone, session);
            //--------------------2015-11-19获取验证码开始----------------------------------
            // 生成四位数验证码
            String sRand = "";
            Random random = new Random();
            for (int i = 0; i < 4; i++) {
                String rand = String.valueOf(random.nextInt(10));
                sRand += rand;
            }
            System.out.println("生成的4位数验证码:" + sRand);

            String content = new String("您的验证码是：" + sRand + "。请不要把验证码泄露给其他人。");
            new SendMessageThread(phone,"您的验证码是：" + sRand + "。请不要把验证码泄露给其他人。", SMSUtils.VALIDATECODE_KEY).start();
            //用线程的方式发送短信
            RespStatusUtil.success(map);
            map.put("data", sRand);
        } catch (Exception e) {
            System.out.println("发送失败"+map);
            RespStatusUtil.error("验证码发送失败", map);
            e.printStackTrace();

        }
        return map;
    }

    @RequestMapping("/appUser/register")
    @ResponseBody
    public Map register(UserForm userForm){
        System.out.println("开始注册");
        Map map = new HashMap();
        String username = userForm.getUserName();
        String realname = userForm.getRealName();
        String level = userForm.getLevel();
        int sex = Integer.valueOf(userForm.getSex());
        String password = userForm.getPassword();
        try{
            List<User> users = appUserService.checkUsername(username);
            if(users.size()!=0){
                RespStatusUtil.error("用户名已经存在", map);
            }else{
                System.out.println("开始注册");
                User u = new User();
                u.setUid(Udid.get32UUID());
                u.setUserName(username);
                u.setPassword(password);
                u.setSex(sex);
                u.setRealName(realname);
                u.setLevel(level);
                String result = appUserService.registerUsername(u);
                if(result!="0"){
                    RespStatusUtil.success(map);
                    map.put("data",u);

                }else{
                    RespStatusUtil.error("注册失败", map);
                }

            }
        }catch (Exception e){
            e.printStackTrace();
        }
        return map;
    }


    @RequestMapping("/appUser/updateUserInfo")
    @ResponseBody
    public Map updateUserInfo(UserForm userForm){
        Map map = new HashMap();
        System.out.println("完善用户信息");
        String uid = userForm.getUid();
        String realname = userForm.getRealName();
        try{
            User u = new User();
            u.setUid(uid);
            u.setRealName(realname);
            String result = appUserService.updateUserInfo(u);
            RespStatusUtil.success(map);
        }catch (Exception e){
            e.printStackTrace();
            RespStatusUtil.error("完善用户信息失败", map);
        }
        return map;
    }

    @RequestMapping("/appUser/login")
    @ResponseBody
    public Map login(UserForm userForm){
        Map map = new HashMap();
        System.out.println("用户登录");
        String userName = userForm.getUserName();
        String password = userForm.getPassword();
        try{
            User u = new User();
            u.setUserName(userName);
            u.setPassword(password);
            System.out.println(u.getUserName()+u.getPassword());
            User resp = appUserService.login(u);
            if(resp!=null){
                RespStatusUtil.success(map);
                map.put("data", resp);
            }else{
                RespStatusUtil.error("用户名密码验证失败", map);
            }

        }catch (Exception e){
            e.printStackTrace();
            RespStatusUtil.error("登录失败", map);
        }
        return map;
    }

    @RequestMapping("/appUser/getUserInfo")
    @ResponseBody
    public Map getUserInfo(UserForm userForm){
        Map map = new HashMap();
        System.out.println("获取用户详情");
        String uid = userForm.getUid();
        try{
            User u = new User();
            u.setUid(uid);
            User resp = appUserService.getUserInfo(u);
            RespStatusUtil.success(map);
            map.put("data",resp);
        }catch (Exception e){
            e.printStackTrace();
            RespStatusUtil.error("登录失败", map);
        }
        return map;
    }

    @RequestMapping("/appUser/forgetPassword")
    @ResponseBody
    public Map forgetPassword(UserForm userForm){
        Map map = new HashMap();
        System.out.println("修改密码");
        String username = userForm.getUserName();
        System.out.println(username);
        String password = userForm.getPassword();
        try{
            User u = new User();
            u.setUserName(username);
            u.setPassword(password);
            List<User> users = appUserService.checkUsername(username);
            if(users.size()>0){
                String resp = appUserService.updateUserPassword(u);
                System.out.println(resp);
                if(resp!="0"){
                    RespStatusUtil.success(map);
                }else{
                    RespStatusUtil.error("密码修改失败", map);
                }
            }else{
                RespStatusUtil.error("用户名不存在", map);
            }



        }catch (Exception e){
            e.printStackTrace();
            RespStatusUtil.error("密码修改失败", map);
        }
        return map;
    }


}
