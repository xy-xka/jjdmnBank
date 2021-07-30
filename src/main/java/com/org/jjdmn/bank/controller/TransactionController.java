package com.org.jjdmn.bank.controller;

import com.org.jjdmn.bank.pojo.Transaction;
import com.org.jjdmn.bank.service.TransactionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

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
@RequestMapping("/tran")
public class TransactionController {

    @Autowired
    private TransactionService service;

    @RequestMapping("/query")
    public String query(){
        Transaction con = new Transaction();
        con.setRecAccountId(111);
        List<Transaction> transactions = service.getTransactionList(con);

        transactions.forEach(System.out::println);
        return "success";
    }
}
