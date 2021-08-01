package com.org.jjdmn.bank.controller;

import com.org.jjdmn.bank.BankApplication;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import static org.junit.jupiter.api.Assertions.*;

/**
 * @author zhangdi
 * @date 2021/7/31 - 11:40
 * @introduction
 */
@RunWith(SpringRunner.class)
@SpringBootTest(classes = BankApplication.class)
public class TransactionControllerTest {
    @Autowired
    private WebApplicationContext webApplicationContext;
    private MockMvc mockMvc;
    @Test
    public void ttt()throws Exception{
        String url = "/tran/query";
        String requestBody = "{\"payAccountId\":\"\"," +
                "\"recAccountId\":\"\"," +
                "\"transactionStatus\":\"\"," +
                "\"transactionTime\":\"\"," +
                "\"pageNum\":\"1\"}";
        mockMvc = MockMvcBuilders.webAppContextSetup(webApplicationContext).build();
        MvcResult result = mockMvc.perform(MockMvcRequestBuilders.post(url).content(requestBody)
                .contentType(MediaType.APPLICATION_JSON).accept(MediaType.APPLICATION_JSON)).andReturn();
        //访问返回状态
        int status = result.getResponse().getStatus();
        System.out.println(status);

        //接口返回结果
        String content = result.getResponse().getContentAsString();
        System.out.println(content);
    }
}