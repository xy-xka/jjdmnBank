package com.org.jjdmn.bank.service.impl;

import com.org.jjdmn.bank.persistence.AccountMapper;
import com.org.jjdmn.bank.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
    private AccountMapper mapper;
}
