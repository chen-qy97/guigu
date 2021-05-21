package com.example.demo.util;

/**
 * 单例模式
 * 1.某个类只能有一个实例
 *  构造器私有化
 *
 * 2.它必须自行创建这个实例
 *  含有一个该类的静态变量来保存这个唯一的实例
 *
 * 3.它必须自行向整个系统提供这个实例
 *  对外提供获取该实例对象的方式：
 *      a、直接暴露  b、用静态变量的get方法获取
 *
 * 饿汉式：在类初始化的时候直接创建对象，不存在线程安全问题
 *  * 直接实例化饿汉式(简洁直观)
 *  * 枚举式(最简洁)
 *  * 静态代码快饿汉式(适合复杂实例化)
 *
 * 懒汉式：延迟创建对象
 *  * 线程不安全(适用于单线程)
 *  * 线程安全(适用于多线程)
 *  * 静态内部类形式(适用于多线程，最简洁)
 *
 * 饿汉式：在类初始化的时候直接创建对象，不管是否需要这个对象都会创建（不存在线程安全问题）
 *  (1) 构造器私有化
 *      private Singleton1_02(){
 *      }
 *
 *  (2) 自行创建，并且用静态变量保存
 *      static Singleton1_02 instance = new Singleton1_02();
 *
 *  (3) 向外提供这个实例
 *      public static Singleton1_02 instance = new Singleton1_02();
 *
 *  (4) 强调这是一个单例，可以使用final修饰
 *      public static final Singleton1_02 instance = new Singleton1_02();
 */
public class Singleton1_02 {

    public static final Singleton1_02 instance = new Singleton1_02();

    private Singleton1_02(){
    }


}
