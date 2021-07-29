package com.org.jjdmn.bank.service.impl;

import com.org.jjdmn.bank.persistence.TransactionMapper;
import com.org.jjdmn.bank.persistence.UserMapper;
import com.org.jjdmn.bank.service.TransactionService;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * @PackageUrl com.org.jjdmn.bank.service.impl
 * @ClassName TransactionServiceImpl
 * @Description TODO
 * @Author huwx
 * @Date 2021/7/29
 * @Version 1.0
 **/
public class TransactionServiceImpl implements TransactionService {

    @Autowired
    private TransactionMapper transactionMapper;

    @Autowired
    private UserMapper userMapper;
}
