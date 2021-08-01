package com.org.jjdmn.bank.service;

import com.org.jjdmn.bank.Util.GetUuid;
import com.org.jjdmn.bank.bankEnum.AccountEnum;
import com.org.jjdmn.bank.bankEnum.TransferEnum;
import com.org.jjdmn.bank.persistence.AccountMapper;
import com.org.jjdmn.bank.pojo.Account;
import com.org.jjdmn.bank.pojo.User;
import com.org.jjdmn.bank.service.AccountService;
import com.org.jjdmn.bank.vo.TranferVo;
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



    @Transactional(propagation = Propagation.REQUIRED, isolation = Isolation.DEFAULT, readOnly = false)
    public synchronized int  doTransfer(long payAccount, long recAcount, BigDecimal amount){

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
    public TranferVo transferCheck(long payAccountId, long recAccountId, String password, BigDecimal amount) {

        System.out.println("开始校验");


        TranferVo vo = new TranferVo();

        Account payAccount = accountMapper.getAccountById(payAccountId);

        Account recAccount = accountMapper.getAccountById(recAccountId);
        if(recAccount==null){
            vo.setCode(TransferEnum.recAccNotExist.getCode());
            vo.setMsg(TransferEnum.recAccNotExist.getDesc());
            return vo;
        }


        // 校验支付密码
        if (!password.equals(payAccount.getPayPwd())) {
            vo.setCode(TransferEnum.passwordError.getCode());
            vo.setMsg(TransferEnum.passwordError.getDesc());
            return vo;
        }

        // 校验对方账户状态
        if (recAccount.getAccountStatus() != AccountEnum.normal.getCode()){
            vo.setCode(AccountEnum.frozen.getCode());
            vo.setMsg("对方账户异常");
            return vo;
        }

        if (amount.compareTo(payAccount.getBalance()) > 0){
            vo.setCode(TransferEnum.balanceNotEnough.getCode());
            vo.setMsg(TransferEnum.balanceNotEnough.getDesc());
            return vo;
        }
        return vo;
    }
}
