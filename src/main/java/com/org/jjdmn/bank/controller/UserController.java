package com.org.jjdmn.bank.controller;

import com.org.jjdmn.bank.pojo.User;
import com.org.jjdmn.bank.service.impl.UserServiceImpl;
import com.org.jjdmn.bank.vo.LoginVo;
import com.org.jjdmn.bank.vo.ResultVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @PackageUrl com.org.jjdmn.bank.controller
 * @ClassName UserController
 * @Description TODO 用户登录注册
 * @Author huwx
 * @Date 2021/7/29
 * @Version 1.0
 **/
@Controller
public class UserController {
    @Autowired
    UserServiceImpl userService;

    @RequestMapping("/")
    public String toLogin(){
        return "index";
    }

    @Autowired
    HttpServletRequest request;

    @RequestMapping(value = "/do_login",method = RequestMethod.POST)
    @ResponseBody
    public ResultVo doLogin(HttpServletResponse response, LoginVo loginVo){
        User user = userService.login(response,loginVo);
        if (user==null) return  new ResultVo().error(user);
        ResultVo result = new ResultVo().success(user);
        request.getSession().setAttribute("user",result);
        System.out.println(user.toString());
        //   User user1 = (User)request.getSession().getAttribute("user");
        return result;
    }

}
