package com.org.jjdmn.bank.pojo;

/**
 * @PackageUrl com.org.jjdmn.bank.pojo
 * @ClassName User
 * @Description TODO
 * @Author huwx
 * @Date 2021/7/29
 * @Version 1.0
 **/
public class User {
    private long userId;  //用户id
    private String username;      // 用户名
    private String password;      //  登录密码
    private String identityCard;   //  身份证
    private String salt;            //随机盐值

    public void setIdentityCard(String identityCard) {
        this.identityCard = identityCard;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setUserId(long userId) {
        this.userId = userId;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setSalt(String salt) {
        this.salt = salt;
    }

    public long getUserId() {
        return userId;
    }

    public String getIdentityCard() {
        return identityCard;
    }

    public String getPassword() {
        return password;
    }

    public String getUsername() {
        return username;
    }

    public String getSalt() {
        return salt;
    }

    @Override
    public String toString() {
        return "User{" +
                "userId=" + userId +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", identityCard='" + identityCard + '\'' +
                ", salt='" + salt + '\'' +
                '}';
    }
}
