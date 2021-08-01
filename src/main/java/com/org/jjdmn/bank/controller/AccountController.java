package com.org.jjdmn.bank.controller;

import com.org.jjdmn.bank.Util.TransferFailList;
import com.org.jjdmn.bank.bankEnum.TransferEnum;
import com.org.jjdmn.bank.pojo.Respon.ResponBean;
import com.org.jjdmn.bank.pojo.User;
import com.org.jjdmn.bank.service.AccountService;

import com.org.jjdmn.bank.vo.ResultVo;
import com.org.jjdmn.bank.vo.TranferVo;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpRequest;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.time.temporal.TemporalAmount;
import java.util.*;

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
    public TranferVo transfering(@RequestBody Map<String, String> map) {

        for (Map.Entry<String, String> entry : map.entrySet()) {
            System.out.println("Key = " + entry.getKey() + ", Value = " + entry.getValue());
        }

        long payAccount = map.get("payAccountId").equals("") ? 0 : Long.parseLong(map.get("payAccountId"));
        long recAccount = map.get("recAccountId").equals("") ? 0 : Long.parseLong(map.get("recAccountId"));
        BigDecimal amount = map.get("amount").equals("") ? new BigDecimal("0") : new BigDecimal(map.get("amount"));
        String payPassword = map.get("payPassword").equals("") ? "" : map.get("payPassword");

        long userId = ((ResultVo) request.getSession().getAttribute("user")).getUserId();

        TranferVo vo = new TranferVo();

        //校验付款账户
        if (accountService.getAcountListService(userId).stream().anyMatch(account -> account.getAccountId() == payAccount)) {

             vo = accountService.transferCheck(payAccount, recAccount, payPassword, amount);
            //转账校验
            if (vo.getCode()!= TransferEnum.tranferSuccess.getCode()) {
                System.out.println(vo);
                return vo;//校验失败
            }
            //转账
            if (accountService.doTransfer(payAccount, recAccount, amount) == 1) {
                request.getSession().setAttribute("accountList",accountService.getAcountListService(userId));
                return vo;
            }
            vo.setCode(TransferEnum.transferFailed.getCode());
            vo.setMsg(TransferEnum.transferFailed.getDesc());
            return vo;
        }
        vo.setCode(TransferEnum.accNotBelongUser.getCode());
        vo.setMsg(TransferEnum.accNotBelongUser.getDesc());
        return vo;
    }
}

