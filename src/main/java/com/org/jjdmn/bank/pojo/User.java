package com.org.jjdmn.bank.pojo;

import java.util.ArrayList;

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
    private ArrayList<Account> accountList;   //  账户列表

    public long getUserId() {
        return userId;
    }

    public void setUserId(long userId) {
        this.userId = userId;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getIdentityCard() {
        return identityCard;
    }

    public void setIdentityCard(String identityCard) {
        this.identityCard = identityCard;
    }

    public ArrayList<Account> getAccountList() {
        return accountList;
    }

    public void setAccountList(ArrayList<Account> accountList) {
        this.accountList = accountList;
    }
}
