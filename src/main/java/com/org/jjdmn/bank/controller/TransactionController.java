package com.org.jjdmn.bank.controller;

import com.org.jjdmn.bank.pojo.Respon.ResponBean;
import com.org.jjdmn.bank.pojo.Transaction;
import com.org.jjdmn.bank.service.TransactionService;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.List;
import java.util.Map;

/**
 * @PackageUrl com.org.jjdmn.bank.controller
 * @ClassName TransactionController
 * @Description TODO  转账流水查询
 * @Author huwx
 * @Date 2021/7/29
 * @Version 1.0
 **/
@Controller
@RequestMapping("tran")
public class TransactionController {

    @Autowired
    private TransactionService service;

    @Autowired
    HttpServletRequest request;

    //查询界面
    @GetMapping("/toQuery")
    public String viewForm(){
        return "query_trans";
    }

    //查询流水
    @ResponseBody
    @RequestMapping(value = "/query", method = RequestMethod.POST)
    public ResponBean<Transaction> query(@RequestBody Map<String,String> map){
        long pay = map.get("payAccountId").equals("") ?  0: Long.parseLong(map.get("payAccountId")) ;
        long rec = map.get("recAccountId").equals("") ?  0:  Long.parseLong(map.get("recAccountId"));
        int status = map.get("transactionStatus").equals("") ?
                0: Integer.parseInt(map.get("transactionStatus")) ;
        int pageNum = Integer.parseInt(map.get("pageNum"));
        Transaction con = new Transaction(null,pay, rec,
                map.get("transactionTime"),null, status );
        System.out.println(con.toString());

        int totalNum = service.getTransactionNum(con);//查询一共有多少条数据
        int pageSize = 2;
        int totalPages = totalNum/pageSize;

        if(pageNum > totalPages){
            pageNum = totalPages;
        }
        if(pageNum <= 0)
            pageNum=1;

        List<Transaction> transactions = service.getTransactionLimitList(con,pageNum,pageSize);
        ResponBean<Transaction> respon = new ResponBean<>(transactions);
        return respon;
    }

}
