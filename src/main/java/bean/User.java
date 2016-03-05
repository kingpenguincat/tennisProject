package bean;

/**
 * Created by liupeng on 16/3/4.
 */
public class User {
    private String uid; //用户id
    private String userName; //用户名（手机号）
    private String password; //密码
    private int regTime; // 注册时间
    private int sex; //性别
    private String level; //球员等级
    private String realName; // 真实姓名
    private String imageUrl; //头像url地址
    private int integrate; //球豆
    private int enroll; //已报名的比赛
    private int attend; //已参加的比赛
    private int win; //赢的比赛
    private int lose;//输的比赛
    private int reward; //奖金总额
    private int enrollMoney; //报名比赛总金额
    private int auth; //是否球室认证
    private int role; //角色
    private int status; //用户状态

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getRealName() {
        return realName;
    }

    public void setRealName(String realName) {
        this.realName = realName;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public int getEnrollMoney() {
        return enrollMoney;
    }

    public void setEnrollMoney(int enrollMoney) {
        this.enrollMoney = enrollMoney;
    }



    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public String getUid() {
        return uid;
    }

    public void setUid(String uid) {
        this.uid = uid;
    }


    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public int getRegTime() {
        return regTime;
    }

    public void setRegTime(int regTime) {
        this.regTime = regTime;
    }

    public int getSex() {
        return sex;
    }

    public void setSex(int sex) {
        this.sex = sex;
    }

    public String getLevel() {
        return level;
    }

    public void setLevel(String level) {
        this.level = level;
    }



    public int getIntegrate() {
        return integrate;
    }

    public void setIntegrate(int integrate) {
        this.integrate = integrate;
    }

    public int getEnroll() {
        return enroll;
    }

    public void setEnroll(int enroll) {
        this.enroll = enroll;
    }

    public int getAttend() {
        return attend;
    }

    public void setAttend(int attend) {
        this.attend = attend;
    }

    public int getWin() {
        return win;
    }

    public void setWin(int win) {
        this.win = win;
    }

    public int getLose() {
        return lose;
    }

    public void setLose(int lose) {
        this.lose = lose;
    }

    public int getReward() {
        return reward;
    }

    public void setReward(int reward) {
        this.reward = reward;
    }


    public int getAuth() {
        return auth;
    }

    public void setAuth(int auth) {
        this.auth = auth;
    }

    public int getRole() {
        return role;
    }

    public void setRole(int role) {
        this.role = role;
    }




}
