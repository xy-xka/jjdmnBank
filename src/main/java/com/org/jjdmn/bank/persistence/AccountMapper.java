package com.org.jjdmn.bank.persistence;

import com.org.jjdmn.bank.pojo.Account;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import java.math.BigDecimal;
import java.util.List;

@Component
@Mapper
public interface AccountMapper {

    /**
     * 获取用户的账号列表
     * @param userId 用户Id
     * @return 用户账号列表
     */
    public List<Account> queryAccountList(long userId);

    // 转账
    /**
     * 付款账号减去转账金额
     * @param payAccountId 付款账号
     * @param amount 转账金额
     * @return
     */
    public int transferPay(@Param("payAccountId") long payAccountId, @Param("amount") BigDecimal amount);
    //

    /**
     * 收款账号加上转账金额
     * @param recAccountId 收款账号
     * @param amount 收款金额
     * @return
     */
    public int transferRec(@Param("recAccountId") long recAccountId, @Param("amount") BigDecimal amount);

    /**
     * 写转账流水
     * @param transactionNo 交易流水号
     * @param payAccountId 付款账号
     * @param recAccountId 收款账号
     * @param transactionTime 转账时间
     * @param transactionAmount 转账金额
     * @param transactionStatus 转账状态
     * @return
     */
    public int saveTransection(@Param("transactionNo") String transactionNo, @Param("payAccountId") long payAccountId, @Param("recAccountId") long recAccountId, @Param("transactionTime") String transactionTime, @Param("transactionAmount") BigDecimal transactionAmount, @Param("transactionStatus") int transactionStatus);


}
