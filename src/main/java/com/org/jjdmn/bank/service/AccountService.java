package com.org.jjdmn.bank.service;

import com.org.jjdmn.bank.pojo.User;
import org.springframework.stereotype.Service;

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
    boolean checkPayAccount(User user, long accountId);

}
