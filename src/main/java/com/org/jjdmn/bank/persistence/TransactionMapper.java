package com.org.jjdmn.bank.persistence;

import com.org.jjdmn.bank.pojo.Transaction;

import java.util.List;

/**
 * @PackageUrl com.org.jjdmn.bank.persistence
 * @ClassName TransactionMapper
 * @Description TODO
 * @Author huwx
 * @Date 2021/7/29
 * @Version 1.0
 **/
public interface TransactionMapper {
    List<Transaction> queryByCondition(Transaction transaction);
}

