package com.org.jjdmn.bank.vo;

/**
 * @PackageUrl com.org.jjdmn.bank.vo
 * @ClassName TranferVo
 * @Description TODO
 * @Author huwx
 * @Date 2021/8/1
 * @Version 1.0
 **/
public class TranferVo {
    private int code = 1;      //状态码
    private String msg = "成功";    //返回消息

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    @Override
    public String toString() {
        return "TranferVo{" +
                "code=" + code +
                ", msg='" + msg + '\'' +
                '}';
    }
}
