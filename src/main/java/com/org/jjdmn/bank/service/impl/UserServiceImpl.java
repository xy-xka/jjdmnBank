package com.org.jjdmn.bank.service.impl;

import com.org.jjdmn.bank.Util.MD5Util;
import com.org.jjdmn.bank.persistence.UserMapper;
import com.org.jjdmn.bank.pojo.User;
import com.org.jjdmn.bank.service.UserService;
import com.org.jjdmn.bank.vo.LoginVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletResponse;

/**
 * @PackageUrl com.org.jjdmn.bank.service.impl
 * @ClassName UserServiceImpl
 * @Description TODO
 * @Author huwx
 * @Date 2021/7/29
 * @Version 1.0
 **/
@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserMapper userMapper;

//    @Autowired
//    private AccountMapper accountMapper;

    @Override
    public User getByusername(String username) {

        User user =  userMapper.getByusername(username);
        return user;
    }
    public User login(HttpServletResponse response, LoginVo loginVo){
        String username = loginVo.getUsername();
        String formPass = loginVo.getPassword();
        User user = getByusername(username);
        if (user==null) return null;
        String dbPass = user.getPassword();
        String saltDB = user.getSalt();
//        String saltDB = "abcdefg";
        String calcPass = MD5Util.formPassToDBPass(formPass,saltDB);
        System.out.println("calcPass:"+calcPass);
        if (!calcPass.equals(dbPass)) return null;
//        if (!dbPass.equals(formPass)) return null;
        return user;
    }
}
