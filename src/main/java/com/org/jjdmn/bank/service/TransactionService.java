package com.org.jjdmn.bank.service;

import com.org.jjdmn.bank.pojo.Transaction;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @PackageUrl com.org.jjdmn.bank.service
 * @ClassName TransactionService
 * @Description TODO
 * @Author huwx
 * @Date 2021/7/29
 * @Version 1.0
 **/
@Service
public interface TransactionService {
    List<Transaction> getTransactionList(Transaction condition);  // 根据组合条件查询交易记录
}
