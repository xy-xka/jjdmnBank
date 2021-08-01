package com.org.jjdmn.bank.Util;

import com.org.jjdmn.bank.controller.TransactionController;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

/**
 * @author zhangdi
 * @date 2021/8/1 - 15:20
 * @introduction
 */

@Aspect
@Component
public class AopLog {

    private static final Logger logger  = LoggerFactory.getLogger(AopLog.class);

    public static final String EDP = "execution(* com.org.jjdmn.bank.service.impl.AccountServiceImpl.doTransfer(..))";

    private long startTime;
    @Before(EDP)
    public void doBefore(JoinPoint joinPoint){
        startTime = System.currentTimeMillis();
        logger.info("开始进行转账事务");
    }
    @After(EDP)
    public void doAfter(JoinPoint joinPoint){
        long totalTime = System.currentTimeMillis()-startTime;

        logger.info("转账事务执行完毕，用时："+totalTime + "ms");
    }
}
