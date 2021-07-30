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

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
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

    @Autowired
    HttpServletRequest request;

    //查询界面
    @GetMapping("/toQuery")
    public String viewForm(){
        return "query_trans";
    }

    //查询流水
    @RequestMapping(value = "/query", method = RequestMethod.POST)
    public String query(@Param("payAccountId") String payAccountId,
                        @Param("recAccountId") String recAccountId,
                        @Param("transactionTime") String transactionTime,
                        @Param("transactionStatus") String transactionStatus){
        long pay = payAccountId.equals("") ?  0: Long.parseLong(payAccountId) ;
        long rec = recAccountId.equals("") ?  0:  Long.parseLong(recAccountId);
        int status = transactionStatus.equals("") ?  0: Integer.parseInt(transactionStatus) ;
        Transaction con = new Transaction(null,pay, rec, transactionTime,null, status );
        List<Transaction> transactions = service.getTransactionList(con);

        //transactions.forEach(System.out::println);
        HttpSession session = request.getSession();
        session.setAttribute("transactions",transactions);
        return "success";
    }
}
