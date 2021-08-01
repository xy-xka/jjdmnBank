package com.org.jjdmn.bank.service;

import com.org.jjdmn.bank.pojo.Account;
import com.org.jjdmn.bank.vo.TranferVo;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;

/**
 * @PackageUrl com.org.jjdmn.bank.service
 * @ClassName AccountService
 * @Description TODO
 * @Author huwx
 * @Date 2021/7/29
 * @Version 1.0
 **/
@Service
public interface AccountService {

    List<Account> getAcountListService(long userId);

    int doTransfer(long payAccount, long recAcount, BigDecimal amount);

    TranferVo transferCheck(long payAccount, long recAccount, String password, BigDecimal amount);
}
