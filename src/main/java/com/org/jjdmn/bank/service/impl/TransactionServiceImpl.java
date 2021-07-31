package com.org.jjdmn.bank.service.impl;

import com.github.pagehelper.PageHelper;
import com.org.jjdmn.bank.persistence.TransactionMapper;
import com.org.jjdmn.bank.persistence.UserMapper;
import com.org.jjdmn.bank.pojo.Transaction;
import com.org.jjdmn.bank.service.TransactionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @PackageUrl com.org.jjdmn.bank.service.impl
 * @ClassName TransactionServiceImpl
 * @Description TODO
 * @Author huwx
 * @Date 2021/7/29
 * @Version 1.0
 **/
@Service
public class TransactionServiceImpl implements TransactionService {

    //调用TransactionMapper
    @Autowired
    private TransactionMapper transactionMapper;

    @Override
    public List<Transaction> getTransactionList(Transaction condition) {
        return transactionMapper.queryByCondition(condition);
    }
    @Override
    public List<Transaction> getTransactionLimitList(Transaction condition, int pageNumber, int pageSize) {
        PageHelper.startPage(pageNumber,pageSize);
        return transactionMapper.queryByCondition(condition);
    }
    @Override
    public int getTransactionNum(Transaction condition){
        return transactionMapper.countNumber(condition);
    }
}
