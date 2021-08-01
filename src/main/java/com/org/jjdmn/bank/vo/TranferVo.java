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
    private int code;      //状态码
    private String msg;    //返回消息

    public TranferVo(int code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    public TranferVo() {

    }


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
}
