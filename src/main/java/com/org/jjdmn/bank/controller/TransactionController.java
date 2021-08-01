package com.org.jjdmn.bank.controller;

import com.org.jjdmn.bank.bankEnum.TransactionEnum;
import com.org.jjdmn.bank.pojo.Respon.ResponBean;
import com.org.jjdmn.bank.pojo.Transaction;
import com.org.jjdmn.bank.service.TransactionService;
import org.apache.ibatis.annotations.Param;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
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

    private static final Logger logger  = LoggerFactory.getLogger(TransactionController.class);
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
    @RequestMapping(value = "/query", method = RequestMethod.POST,produces = {"application/json;charset=UTF-8"})
    public ResponBean<Transaction> query(@RequestBody Map<String,String> map){
        long pay = "".equals(map.get("payAccountId")) ?  0: Long.parseLong(map.get("payAccountId")) ;
        long rec = "".equals(map.get("recAccountId")) ?  0:  Long.parseLong(map.get("recAccountId"));
        int status = 0;

        System.out.println(map.get("transactionStatus"));
        System.out.println(TransactionEnum.success.getDesc());
        System.out.println(map.get("transactionStatus").equals(TransactionEnum.success.getDesc()));

        if(map.get("transactionStatus").equals(TransactionEnum.success.getDesc()))
            status = TransactionEnum.success.getCode();
        if(map.get("transactionStatus").equals(TransactionEnum.fail.getDesc()))
            status = TransactionEnum.fail.getCode();
        if(map.get("transactionStatus").equals(TransactionEnum.handler.getDesc()))
            status = TransactionEnum.handler.getCode();
        int pageNum = Integer.parseInt(map.get("pageNum"));
        Transaction con = new Transaction(null,pay, rec,
                map.get("transactionTime"),null, status );
        System.out.println(con.toString());

        logger.info(con.toString());

        double totalNum = service.getTransactionNum(con);//查询一共有多少条数据
        double pageSize = 5;
        int totalPages = (int)Math.ceil(totalNum/pageSize);

        if(pageNum > totalPages){
            pageNum = totalPages;
        }
        if(pageNum <= 0)
            pageNum=1;

        List<Transaction> transactions = service.getTransactionLimitList(con,pageNum,(int)pageSize);
        System.out.println(transactions);
        ResponBean<Transaction> respon = new ResponBean<>(transactions);
        respon.setMsg(totalPages+"");
        return respon;
    }

}
