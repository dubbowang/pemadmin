package com.qinke.pemadmin.utils;

import java.security.MessageDigest;

public class MD5Util {
    public static void main(String args []) {
        try {
            // 获得MD5摘要算法的 MessageDigest对象
            MessageDigest mdInst = MessageDigest.getInstance("MD5");
            // 使用指定的字节更新摘要
            mdInst.update("易处理修理厂58eff5c2c9dd7f68543e3058f208485a".getBytes());
            // 获得密文
            byte[] md = mdInst.digest();
            // 把密文转换成十六进制的字符串形式
            StringBuffer buf = new StringBuffer();
            for (int i = 0; i < md.length; i++) {
                int tmp = md[i];
                if (tmp < 0)
                    tmp += 256;
                if (tmp < 16)
                    buf.append("0");
                buf.append(Integer.toHexString(tmp));
            }

            System.out.println(buf.toString());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}