package com.org.jjdmn.bank.persistence;

import com.org.jjdmn.bank.pojo.Account;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * @PackageUrl com.org.jjdmn.bank.persistence
 * @ClassName AccountMapper
 * @Description TODO
 * @Author huwx
 * @Date 2021/7/29
 * @Version 1.0
 **/
@Mapper
public interface AccountMapper {
    List<Account> getAccountListByUserId(long userId);


}
