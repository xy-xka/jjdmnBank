package com.org.jjdmn.bank.controller;

import com.org.jjdmn.bank.pojo.User;
import com.org.jjdmn.bank.service.AccountService;

import com.org.jjdmn.bank.vo.ResultVo;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpRequest;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import sun.security.util.Password;

import javax.servlet.http.HttpServletRequest;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.time.temporal.TemporalAmount;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

/**
 * @PackageUrl com.org.jjdmn.bank.controller
 * @ClassName AccountController
 * @Description TODO 选择账户
 * @Author huwx
 * @Date 2021/7/29
 * @Version 1.0
 **/

@Controller
@RequestMapping("/account")
public class AccountController {


    @Autowired
    AccountService accountService;

    @Autowired
    HttpServletRequest request;

    @ResponseBody
    @RequestMapping(value = "/transfering", method = RequestMethod.POST, produces = {"application/json;charset=UTF-8"})
    public String transfering(@RequestBody Map<String, String> map) {

        for (Map.Entry<String, String> entry : map.entrySet()) {
            System.out.println("Key = " + entry.getKey() + ", Value = " + entry.getValue());
        }

        long payAccount = map.get("payAccountId").equals("") ? 0 : Long.parseLong(map.get("payAccountId"));
        long recAccount = map.get("recAccountId").equals("") ? 0 : Long.parseLong(map.get("recAccountId"));
        BigDecimal amount = map.get("amount").equals("") ? new BigDecimal("0") : new BigDecimal(map.get("amount"));
        String payPassword = map.get("payPassword").equals("") ? "" : map.get("payPassword");

        long userId = ((ResultVo) request.getSession().getAttribute("user")).getUserId();

        //校验付款账户
        if (accountService.getAcountListService(userId).stream().anyMatch(account -> account.getAccountId() == payAccount)) {

            //转账校验
            if (!accountService.transferCheck(payAccount, recAccount, payPassword, amount).isFlag()) {
                return "transfer";
            }
            //转账
            if (accountService.doTransfer(payAccount, recAccount, amount) == 1) {
                request.getSession().setAttribute("accountList",accountService.getAcountListService(userId));
                return "home";
            }

            return "tranfer";
        }
        return "transfer";
//    }

        //

//    // 转账操作_查询用户账户列表,返回到前端
//    //查询界面
//    @RequestMapping("/getAccountList")
//    public String getAcountList(){
//        User user = (User) request.getSession().getAttribute("user");
//        long userId = user.getUserId();
//        // BigInteger userId = new BigInteger("12345678");
//        Collection acountList = accountService.getAcountListService(userId);
//
//
//        return "query_trans";
//    }

        // 转账操作

    /*
    @RequestMapping(value="/empAdd", method= RequestMethod.POST)
    public String empInput(Employee employee){
        this.employeeDao.save(employee);
        return "redirect:/emp/list";
    }
     */
//    @RequestMapping(value = "/transferAcount")
//    public String transferAounct(Map<String, Object> map){
//
//
//        // 打开前端表单, 变成参数
//        // 传入service 的方法
//
//        HashMap<String, Object> transferparam = new HashMap<>();
//        if(accountService.transferCheck(transferparam).flag){
//            final String uuid = MyUtil.getUUID();
//            if(accountService.transferAcount(map)){
//                accountService.saveTransctionSerial(uuid, new BigInteger("1"),new BigInteger("1"),"20210731",new BigDecimal("1232"), true);
//                return "执行转账成功逻辑,生成UUID, 存储转账流水, 跳转到转账成功页面";
//            }
//            else{
//
//                accountService.saveTransctionSerial(uuid, new BigInteger("1"),new BigInteger("1"),"20210731",new BigDecimal("1232"), false);
//                return "执行转账失败逻辑, 系统繁忙,稍后重试";
//            }
//        }
//        else{
//
//
//            return "执行信息错误逻辑, 返回原页面,增加错误信息,重新填写";
//        }
//    }
    }
}

