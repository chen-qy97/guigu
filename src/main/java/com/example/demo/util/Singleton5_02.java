package com.example.demo.util;

import java.util.concurrent.*;

/**
 * 懒汉式：
 * 延迟创建这个实例对象
 * <p>
 * 线程安全，适用于多线程
 * <p>
 * (1)构造器私有化
 * (2)用一个静态变量保存这个唯一的实例
 * (3)提供一个静态方法，获取这个实例对象
 */
public class Singleton5_02 {

    private static Singleton5_02 instance;

    private Singleton5_02() {

    }

    public static Singleton5_02 getInstance() {
        if (instance == null) {
            synchronized (Singleton5_02.class) {
                if(instance == null) {
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    instance = new Singleton5_02();
                }
            }
        }
        return instance;
    }
}

class Test5 {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        /*Singleton5_02 s1 = Singleton5_02.getInstance();
        Singleton5_02 s2 = Singleton5_02.getInstance();

        System.out.println(s1 == s2);
        System.out.println(s1);
        System.out.println(s2);*/

        //测试线程安全问题
        Callable<Singleton5_02> c = new Callable<Singleton5_02>() {
            @Override
            public Singleton5_02 call() throws Exception {
                return Singleton5_02.getInstance();
            }
        };

        ExecutorService es = Executors.newFixedThreadPool(2);
        Future<Singleton5_02> f1 = es.submit(c);
        Future<Singleton5_02> f2 = es.submit(c);

        Singleton5_02 s1 = f1.get();
        Singleton5_02 s2 = f2.get();
        System.out.println(s1);
        System.out.println(s2);

        es.shutdown();
    }
}
