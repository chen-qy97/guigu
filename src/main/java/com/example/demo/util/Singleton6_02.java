package com.example.demo.util;

import java.util.concurrent.*;

/**
 * 懒汉式：
 * 延迟创建这个实例对象
 *
 * 静态内部类形式(适用于多线程)
 *
 * 在内部类被家在和出事化时，才创建INSTANCE实例对象
 * 静态内部类不会自动随着外部类的加载和初始化而初识化，它是要单独去加载和初始化的
 * 因为是在内部类加载和初始化时，创建的，因此线程安全的
 *
 */
public class Singleton6_02 {

    private Singleton6_02(){

    }

    private static class Inner{
        private static final Singleton6_02 INSTANCE = new Singleton6_02();
    }

    public static Singleton6_02 getInstance(){
        return Inner.INSTANCE;
    }

}

class Test6{
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        Singleton6_02 s1 = Singleton6_02.getInstance();
        Singleton6_02 s2 = Singleton6_02.getInstance();

        System.out.println(s1 == s2);
        System.out.println(s1);
        System.out.println(s2);

        //测试线程安全问题
        Callable<Singleton6_02> c = new Callable<Singleton6_02>() {
            @Override
            public Singleton6_02 call() throws Exception {
                return Singleton6_02.getInstance();
            }
        };

        ExecutorService es = Executors.newFixedThreadPool(2);
        Future<Singleton6_02> f1 = es.submit(c);
        Future<Singleton6_02> f2 = es.submit(c);

        Singleton6_02 singleton4021 = f1.get();
        Singleton6_02 singleton4022 = f2.get();
        System.out.println(singleton4021);
        System.out.println(singleton4022);

        es.shutdown();



    }
}
