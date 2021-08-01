package com.org.jjdmn.bank.service.impl;

import com.org.jjdmn.bank.Util.GetUuid;
import com.org.jjdmn.bank.Util.TransferFailList;
import com.org.jjdmn.bank.persistence.AccountMapper;
import com.org.jjdmn.bank.pojo.Account;
import com.org.jjdmn.bank.pojo.User;
import com.org.jjdmn.bank.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import javax.validation.constraints.Pattern;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

/**
 * @PackageUrl com.org.jjdmn.bank.service.impl
 * @ClassName AccountServiceImpl
 * @Description TODO
 * @Author huwx
 * @Date 2021/7/29
 * @Version 1.0
 **/
@Service
public class AccountServiceImpl implements AccountService {


    @Autowired
    private AccountMapper accountMapper;


    @Override
    public List<Account> getAcountListService(long userId) {
        return accountMapper.queryAccountList(userId);
    }




    public int doTransfer(long payAccount, long recAcount, BigDecimal amount){

        System.out.println("开始转账");

        String transectionNo = GetUuid.getUUID_8();

        String transectionTime = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date());

        SuccessFlag successFlag = new SuccessFlag(false);

        transferring(payAccount, recAcount, amount,successFlag);
        if(successFlag.isFlag()){
            System.out.println("转账成功");
        }else {
            System.out.println("转账失败");
        }
        accountMapper.saveTransection(transectionNo, payAccount, recAcount,transectionTime,amount,(successFlag.isFlag()?1:2));
        return  successFlag.isFlag()?1:2;

    }

    @Transactional(propagation = Propagation.REQUIRED, isolation = Isolation.DEFAULT, readOnly = false)
    public void transferring(long payAccount, long recAccount, BigDecimal amount, SuccessFlag transectionstatus) {

//        System.out.println("开始转账!!!");
//        System.out.println(amount);
        accountMapper.transferPay(payAccount, amount);
        accountMapper.transferRec(recAccount, amount);
        transectionstatus.setFlag(true);
    }

    class SuccessFlag{
        private boolean flag;

        public SuccessFlag(boolean flag) {
            this.flag = flag;
        }

        public boolean isFlag() {
            return flag;
        }

        public void setFlag(boolean flag) {
            this.flag = flag;
        }
    }


    @Override
    public TransferFailList transferCheck(long payAccount, long recAccount, String password, BigDecimal amount) {


        TransferFailList failList = new TransferFailList();
//        String payPassword = accountMapper.getAccountPasswordByAccountId(long payAccount);
//
//
//
//        // 校验支付密码
//        if(!accountMapper.checkPayAccountAndPassword(new BigInteger(map.get("userId").toString()), map.get("password").toString())){
//            failList.addFail("密码错误");
//        }
//        // 校验对方账户是否存在以及是否正常
//        if(mapper.checkRecUseridAndAccount(new BigInteger(map.get("recUserId").toString()), new BigInteger(map.get("recAccount").toString()))){
//            failList.addFail("对方用户名/账户错误");
//        }
//
//        // 校验账户余额
//        BigDecimal balance = mapper.getBalance((long) map.get("accountId"));
//        if(new BigDecimal(map.get("amount").toString()).compareTo(balance) == -1){
//            failList.addFail("余额不足");
//        }
//        System.out.println("转账前校验");

        return failList;
    }

}
