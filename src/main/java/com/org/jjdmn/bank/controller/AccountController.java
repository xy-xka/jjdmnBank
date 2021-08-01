package com.org.jjdmn.bank.controller;

import com.org.jjdmn.bank.pojo.User;
import com.org.jjdmn.bank.service.AccountService;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;

/**
 * @PackageUrl com.org.jjdmn.bank.controller
 * @ClassName AccountController
 * @Description TODO 选择账户
 * @Author huwx
 * @Date 2021/7/29
 * @Version 1.0
 **/

@Controller
public class AccountController {

    @Autowired
    AccountService accountService;

    @Autowired
    HttpServletRequest request;
    @RequestMapping("/check")
    public String checkAccount(@Param("payaccountId") long payaccountId){
        accountService.checkPayAccount((User)request.getSession().getAttribute("user"),payaccountId);
        return "";
    }

}
