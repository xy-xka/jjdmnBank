package com.org.jjdmn.bank.pojo;

import org.springframework.stereotype.Repository;

import java.io.Serializable;
import java.math.BigDecimal;

/**
 * @PackageUrl com.org.jjdmn.bank.pojo
 * @ClassName Transaction
 * @Description TODO
 * @Author huwx
 * @Date 2021/7/29
 * @Version 1.0
 **/
@Repository
public class Transaction implements Serializable {
    private String transactionNo;  //交易编号，UUID
    private long payAccountId;     //付款账户
    private long recAccountId;    //收款账户
    private String transactionTime;    //交易时间
    private BigDecimal transactionAmount;    //交易金额
    private int transactionStatus;     //交易状态

    public String getTransactionNo() {
        return transactionNo;
    }

    public void setTransactionNo(String transactionNo) {
        this.transactionNo = transactionNo;
    }

    public long getPayAccountId() {
        return payAccountId;
    }

    public void setPayAccountId(long payAccountId) {
        this.payAccountId = payAccountId;
    }

    public long getRecAccountId() {
        return recAccountId;
    }

    public void setRecAccountId(long recAccountId) {
        this.recAccountId = recAccountId;
    }

    public String getTransactionTime() {
        return transactionTime;
    }

    public void setTransactionTime(String transactionTime) {
        this.transactionTime = transactionTime;
    }

    public BigDecimal getTransactionAmount() {
        return transactionAmount;
    }

    public void setTransactionAmount(BigDecimal transactionAmount) {
        this.transactionAmount = transactionAmount;
    }

    public int getTransactionStatus() {
        return transactionStatus;
    }

    public void setTransactionStatus(int transactionStatus) {
        this.transactionStatus = transactionStatus;
    }

    @Override
    public String toString() {
        return "Transaction{" +
                "transactionNo='" + transactionNo + '\'' +
                ", payAccountId=" + payAccountId +
                ", recAccountId=" + recAccountId +
                ", transactionTime='" + transactionTime + '\'' +
                ", transactionAmount=" + transactionAmount +
                ", transactionStatus=" + transactionStatus +
                '}';
    }
}
