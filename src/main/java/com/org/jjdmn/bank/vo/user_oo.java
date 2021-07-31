package com.org.jjdmn.bank.vo;

import java.io.Serializable;

public class user_oo implements Serializable {
    private String username;
    private String orign_password;
    private String db_password;
    private String md5_value;
    private long card;

    public String getUsername() {
        return username;
    }

    public long getCard() {
        return card;
    }

    public String getDb_password() {
        return db_password;
    }

    public String getMd5_value() {
        return md5_value;
    }

    public String getOrign_password() {
        return orign_password;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setCard(long card) {
        this.card = card;
    }

    public void setDb_password(String db_password) {
        this.db_password = db_password;
    }

    public void setMd5_value(String md5_value) {
        this.md5_value = md5_value;
    }

    public void setOrign_password(String orign_password) {
        this.orign_password = orign_password;
    }

    @Override
    public String toString() {
        return "user_oo{" +
                "username='" + username + '\'' +
                ", orign_password='" + orign_password + '\'' +
                ", db_password='" + db_password + '\'' +
                ", md5_value='" + md5_value + '\'' +
                ", card=" + card +
                '}';
    }
}
