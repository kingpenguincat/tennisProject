package service;

import bean.User;
import dao.GeneralDaoImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by liupeng on 16/3/4.
 */
@Service
public class AppUserService {
    @Autowired
    private GeneralDaoImpl generalDaoImpl;

    //检查用户名唯一
    public List<User> checkUsername(String username) throws Exception {
        return (List<User>) generalDaoImpl.findForList("user.checkUsername", username);
    }

    //新建用户
    public String registerUsername(User user) throws Exception{
        Integer i = (Integer) generalDaoImpl.add("user.regUser", user);
        if(i == 1){
            return user.getUid();
        }
        return "0";
    }


    //更新用户信息
    public String updateUserInfo(User user) throws Exception{
        Integer i = (Integer) generalDaoImpl.update("user.updateUserInfo", user);
        if(i == 1){
            return user.getUid();
        }
        return "0";
    }

    //用户登录
    public User login(User user) throws Exception{
        return (User) generalDaoImpl.findForObject("user.login",user);
    }

    //获取用户详情
    public User getUserInfo(User user) throws Exception{
        return (User) generalDaoImpl.findForObject("user.getUserInfo",user);
    }

    //更新用户密码
    public String updateUserPassword(User user) throws Exception{
        Integer i = (Integer) generalDaoImpl.update("user.updateUserPassword", user);
        System.out.println(i);
        if(i == 1){
            return user.getUid();
        }
        return "0";
    }


}
