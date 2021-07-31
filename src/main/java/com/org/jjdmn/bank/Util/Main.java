package com.org.jjdmn.bank.Util;

import com.org.jjdmn.bank.Util.MD5Util;
import com.org.jjdmn.bank.vo.user_oo;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.HashMap;
import java.util.Random;

//密码生成

public class Main {

    public static void main(String[] args) {

        int num = 10;
        HashMap<String, user_oo> save = new HashMap<>();
        Random random = new Random();
        while (num>0){
            String temp_username = getRandomString(random.nextInt(6)+3);
            if (save.get(temp_username)==null){
                num --;
                user_oo temp_user = new user_oo();
                temp_user.setUsername(temp_username);
                temp_user.setOrign_password(getRandomString(random.nextInt(6)+6));
                temp_user.setMd5_value(getRandomString(6));
                temp_user.setDb_password(MD5Util.formPassToDBPass(MD5Util.formPassToDBPass(temp_user.getOrign_password(),"0123456789abcdef"),temp_user.getMd5_value()));
                save.put(temp_username,temp_user);
            }
            else continue;
        }
//        System.out.println(save.toString());

        try {
            ObjectOutputStream outputStream = new ObjectOutputStream(new FileOutputStream("../usersave.txt"));
            outputStream.writeObject(save.toString());
            System.out.println(save);
            outputStream.flush();
            outputStream.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    //生成随机字符串
    public static String getRandomString(int length){
        String str="abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789";
        Random random=new Random();
        StringBuffer sb=new StringBuffer();
        for(int i=0;i<length;i++){
            int number=random.nextInt(62);
            sb.append(str.charAt(number));
        }
        return sb.toString();
    }
}
