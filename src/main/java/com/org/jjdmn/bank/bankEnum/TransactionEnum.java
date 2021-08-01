package com.org.jjdmn.bank.bankEnum;

/**
 * @PackageUrl com.org.jjdmn.bank.bankEnum
 * @ClassName TransactionEnum
 * @Description TODO
 * @Author huwx
 * @Date 2021/7/30
 * @Version 1.0
 **/
public enum TransactionEnum {

    // 转账成功
    success(1,"成功"),

    //转账失败
    fail(2,"失败"),

    //银行处理
    handler(3,"待处理");


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

    TransactionEnum(Integer code, String desc) {
        this.code = code;
        this.desc = desc;
    }
}
