package com.org.jjdmn.bank.service.impl;

import com.org.jjdmn.bank.persistence.AccountMapper;
import com.org.jjdmn.bank.persistence.UserMapper;
import com.org.jjdmn.bank.pojo.Account;
import com.org.jjdmn.bank.pojo.User;
import com.org.jjdmn.bank.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @PackageUrl com.org.jjdmn.bank.service.impl
 * @ClassName AccountServiceImpl
 * @Description TODO
 * @Author huwx
 * @Date 2021/7/29
 * @Version 1.0
 **/
@Service
public class AccountServiceImpl implements AccountService {

    @Autowired
    private AccountMapper accountMapper;



    @Override
    public boolean checkPayAccount(User user, long accountId) {

        List<Account> accountList = accountMapper.getAccountListByUserId(user.getUserId());

        return accountList.stream().anyMatch(account -> account.getAccountId()==accountId);
    }
}
