package com.org.jjdmn.bank.service.impl;

import com.org.jjdmn.bank.persistence.AccountMapper;
import com.org.jjdmn.bank.persistence.UserMapper;
import com.org.jjdmn.bank.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * @PackageUrl com.org.jjdmn.bank.service.impl
 * @ClassName UserServiceImpl
 * @Description TODO
 * @Author huwx
 * @Date 2021/7/29
 * @Version 1.0
 **/
public class UserServiceImpl implements UserService {

    @Autowired
    private UserMapper userMapper;

    @Autowired
    private AccountMapper accountMapper;
}
