package com.example.demo.util;

import java.util.concurrent.*;

/**
 * 懒汉式：
 * 延迟创建这个实例对象
 *
 * 线程不安全，适用于单线程
 *
 * (1)构造器私有化
 * (2)用一个静态变量保存这个唯一的实例
 * (3)提供一个静态方法，获取这个实例对象
 */
public class Singleton4_02 {

    private static Singleton4_02 instance;

    private Singleton4_02(){

    }

    public static Singleton4_02 getInstance(){
        if(instance == null){
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            instance = new Singleton4_02();
        }
        return instance;
    }



}

class Test4{
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        Singleton4_02 s1 = Singleton4_02.getInstance();
        Singleton4_02 s2 = Singleton4_02.getInstance();

        System.out.println(s1 == s2);
        System.out.println(s1);
        System.out.println(s2);

        //测试线程安全问题
        Callable<Singleton4_02> c = new Callable<Singleton4_02>() {
            @Override
            public Singleton4_02 call() throws Exception {
                return Singleton4_02.getInstance();
            }
        };

        ExecutorService es = Executors.newFixedThreadPool(2);
        Future<Singleton4_02> f1 = es.submit(c);
        Future<Singleton4_02> f2 = es.submit(c);

        Singleton4_02 singleton4021 = f1.get();
        Singleton4_02 singleton4022 = f2.get();
        System.out.println(singleton4021);
        System.out.println(singleton4022);

        es.shutdown();



    }
}
