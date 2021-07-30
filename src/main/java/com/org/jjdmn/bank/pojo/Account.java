package com.org.jjdmn.bank.pojo;

import java.math.BigDecimal;

/**
 * @PackageUrl com.org.jjdmn.bank.pojo
 * @ClassName Account
 * @Description TODO
 * @Author huwx
 * @Date 2021/7/29
 * @Version 1.0
 **/
public class Account implements java.io.Serializable{
    private long accountId;   //账户id
    private String userId;    //用户id
    private String openTime;    //开户时间
    private BigDecimal balance;   //账户余额
    private String payPwd;       //支付密码
    private int accountStatus;     //账户状态

    public long getAccountId() {
        return accountId;
    }

    public void setAccountId(long accountId) {
        this.accountId = accountId;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getOpenTime() {
        return openTime;
    }

    public void setOpenTime(String openTime) {
        this.openTime = openTime;
    }

    public BigDecimal getBalance() {
        return balance;
    }

    public void setBalance(BigDecimal balance) {
        this.balance = balance;
    }

    public String getPayPwd() {
        return payPwd;
    }

    public void setPayPwd(String payPwd) {
        this.payPwd = payPwd;
    }

    public int getAccountStatus() {
        return accountStatus;
    }

    public void setAccountStatus(int accountStatus) {
        this.accountStatus = accountStatus;
    }

    @Override
    public String toString() {
        return "Account{" +
                "accountId=" + accountId +
                ", userId='" + userId + '\'' +
                ", openTime='" + openTime + '\'' +
                ", balance=" + balance +
                ", payPwd='" + payPwd + '\'' +
                ", accountStatus=" + accountStatus +
                '}';
    }
}
