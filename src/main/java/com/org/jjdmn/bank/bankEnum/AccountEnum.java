package com.org.jjdmn.bank.bankEnum;

import java.io.Serializable;

/**
 * @PackageUrl com.org.jjdmn.bank.bankEnum
 * @ClassName AccountEnum
 * @Description TODO
 * @Author huwx
 * @Date 2021/7/30
 * @Version 1.0
 **/
public enum AccountEnum implements Serializable {



    //正常账户
    normal(1,"正常"),

    //冻结账户
    frozen(2,"冻结"),

    //销户
    cancellation(3,"销户"),

    //挂失
    loss(4,"挂失");

    private Integer code;  //状态码
    private String desc;    //描述

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    AccountEnum(Integer code, String desc) {
        this.code = code;
        this.desc = desc;
    }
}
