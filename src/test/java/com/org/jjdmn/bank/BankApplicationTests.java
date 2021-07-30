package com.org.jjdmn.bank;

import com.org.jjdmn.bank.pojo.Transaction;
import com.org.jjdmn.bank.service.TransactionService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@SpringBootTest(classes = BankApplication.class)
@RunWith(SpringRunner.class)
public class BankApplicationTests {

    @Test
    public void contextLoads() {
    }

}
