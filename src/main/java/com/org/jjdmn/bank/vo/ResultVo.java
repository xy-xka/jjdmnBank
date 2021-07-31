package com.org.jjdmn.bank.vo;

import com.org.jjdmn.bank.pojo.User;

public class ResultVo {
    private long userId;
    private String username;
    private int code;
    private String msg;


    public long getUserId() {
        return userId;
    }

    public String getUsername() {
        return username;
    }

    public int getCode() {
        return code;
    }

    public String getMsg() {
        return msg;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setUserId(long userId) {
        this.userId = userId;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    @Override
    public String toString() {
        return "ResultVo{" +
                "userId=" + userId +
                ", username='" + username + '\'' +
                ", code=" + code +
                ", msg='" + msg + '\'' +
                '}';
    }

    public ResultVo success(User user){
        this.code = 0;
        this.userId=user.getUserId();
        this.username = user.getUsername();
        this.msg="登录成功！";
        return this;
    }
    public ResultVo error(User user){
        this.code=1;
        this.msg = "用户名或密码错误！";
        return this;
    }
}
