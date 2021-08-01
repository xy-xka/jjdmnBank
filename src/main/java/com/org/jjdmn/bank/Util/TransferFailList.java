package com.org.jjdmn.bank.Util;

import java.util.List;

/**
 * @author css
 * @Description
 * @create 2021-07-31 14:38
 */

public class TransferFailList {

    // 错误标志位, 默认为真,列表中存在错误信息的时候, 置为false.
    private boolean flag = true;

    // 错误列表, 表单中错误数据的名,每次出现错误,将错误名存入,用于最后返回给前端展示
    private String error;

    public void addFail(String failMassage){
        flag = false;
        error = failMassage;
    }

    public boolean isFlag() {
        return flag;
    }

    public void setFlag(boolean flag) {
        this.flag = flag;
    }

    public String getError() {
        return error;
    }

    public void setError(String error) {
        this.error = error;
    }
}
