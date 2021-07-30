package com.org.jjdmn.bank.controller;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * @PackageUrl com.org.jjdmn.bank.controller
 * @ClassName IndexController
 * @Description TODO   界面展示
 * @Author huwx
 * @Date 2021/7/29
 * @Version 1.0
 **/

@Controller
public class IndexController {
    /*
    展示主页面，基本页面的跳转逻辑
     */

    @GetMapping("/") //展示主页面 index.html
    public String viewLogin() {

        return "index";
    }


}