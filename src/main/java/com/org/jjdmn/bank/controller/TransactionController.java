package com.org.jjdmn.bank.controller;

import com.org.jjdmn.bank.pojo.Transaction;
import com.org.jjdmn.bank.service.TransactionService;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

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

    @GetMapping("table")
    public String table(){
        System.out.println("hhhhhhh ");
        return "query_trans";
    }
    @RequestMapping(value = "/query", method = RequestMethod.POST)
    public String query(@Param("payAccountId") Long payAccountId,
                        @Param("recAccountId") Long recAccountId,
                        @Param("transactionTime") String transactionTime,
                        @Param("transactionStatus") String transactionStatus){
        int status = transactionStatus == "" ?  0:Integer.parseInt(transactionStatus) ;
        Transaction con = new Transaction(null,payAccountId, recAccountId, transactionTime,null, status );
        List<Transaction> transactions = service.getTransactionList(con);

        transactions.forEach(System.out::println);
        return "success";
    }
}
