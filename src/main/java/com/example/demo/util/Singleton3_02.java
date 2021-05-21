package com.example.demo.util;

import java.io.IOException;
import java.util.Properties;

/**
 * 饿汉式：静态代码块
 */
public class Singleton3_02 {

    public static Singleton3_02 INSTANCE;
    private String info;

    static {
        try {
            Properties pro = new Properties();

            pro.load(Singleton3_02.class.getResourceAsStream("singleton.properties"));
            INSTANCE = new Singleton3_02(pro.getProperty("info"));
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    private Singleton3_02(String info) {

    }

    public String getInfo() {
        return info;
    }

    public void setInfo(String info) {
        this.info = info;
    }

    @Override
    public String toString() {
        return "Singleton3_02{" +
                "info='" + info + '\'' +
                '}';
    }

    public static void main(String[] args) {
        Singleton3_02 s = Singleton3_02.INSTANCE;
        System.out.println(s);
    }
}
