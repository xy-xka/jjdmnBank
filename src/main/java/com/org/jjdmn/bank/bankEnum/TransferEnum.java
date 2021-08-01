package com.org.jjdmn.bank.bankEnum;

/**
 * @PackageUrl com.org.jjdmn.bank.bankEnum
 * @ClassName TransferEnum
 * @Description TODO
 * @Author huwx
 * @Date 2021/8/1
 * @Version 1.0
 **/
public enum TransferEnum {

    transferFailed(0, "失败"),
    //转账成功
    tranferSuccess(1,"成功"),

    accNotBelongUser(2,"您没有这个账户"),

    recAccNotExist(3,"收款账户不存在"),

    passwordError(4,"支付密码错误"),

    recAccError(5,"对方账户异常"),

    balanceNotEnough(6,"当前账户余额不足")
    ;

    private Integer code;

    private String desc;

    TransferEnum(Integer code, String desc) {
        this.code = code;
        this.desc = desc;
    }

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
}
