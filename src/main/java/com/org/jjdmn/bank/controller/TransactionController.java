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

//    //查询流水
//    @RequestMapping(value = "/query", method = RequestMethod.POST)
//    public String query(HttpServletRequest request){
//        long pay = request.getParameter("payAccountId").equals("") ?  0: Long.parseLong(request.getParameter("payAccountId")) ;
//        long rec = request.getParameter("recAccountId").equals("") ?  0:  Long.parseLong(request.getParameter("recAccountId"));
//        int status = request.getParameter("transactionStatus").equals("") ?
//                0: Integer.parseInt(request.getParameter("transactionStatus")) ;
//        Transaction con = new Transaction(null,pay, rec,
//                request.getParameter("transactionTime"),null, status );
//        List<Transaction> transactions = service.getTransactionList(con);
//
//        //transactions.forEach(System.out::println);
//        HttpSession session = request.getSession();
//        session.setAttribute("transactions",transactions);
//        return "success";
//    }

    //查询流水
    @ResponseBody
    @RequestMapping(value = "/query", method = RequestMethod.POST)
    public ResponBean<Transaction> query(@RequestBody Map<String,String> map){
//        System.out.println(map.toString());
//        System.out.println(map.get("payAccountId"));
        long pay = map.get("payAccountId").equals("") ?  0: Long.parseLong(map.get("payAccountId")) ;
        long rec = map.get("recAccountId").equals("") ?  0:  Long.parseLong(map.get("recAccountId"));
        int status = map.get("transactionStatus").equals("") ?
                0: Integer.parseInt(map.get("transactionStatus")) ;
        Transaction con = new Transaction(null,pay, rec,
                map.get("transactionTime"),null, status );
        System.out.println(con.toString());

        List<Transaction> transactions = service.getTransactionList(con);
        ResponBean<Transaction> respon = new ResponBean<>(transactions);
        return respon;
    }

}
