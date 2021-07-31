/**
 * @Description: 返回数据
 * @author: GSY
 * @date: 2021年07月14日 22:32
 */
package com.org.jjdmn.bank.pojo.Respon;

import java.util.List;

public class ResponBean<T> {

    private int code;
    private String msg;
    private long count;
    private List<T> data;

    public ResponBean(List<T> data){
        this.data = data;
        this.code = 0;
        this.msg = "";
        this.count = data.size();
    }

    public ResponBean(){}


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

    public long getCount() {
        return count;
    }

    public void setCount(long count) {
        this.count = count;
    }

    public List<T> getData() {
        return data;
    }

    public void setData(List<T> data) {
        this.data = data;
    }


    @Override
    public String toString() {
        return "ResponBean{" +
                "code=" + code +
                ", msg='" + msg + '\'' +
                ", count=" + count +
                ", data=" + data +
                '}';
    }
}
