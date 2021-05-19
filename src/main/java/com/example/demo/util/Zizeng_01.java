package com.example.demo.util;

/**
 * 变量自增
 */
public class Zizeng_01 {

    public static void main(String[] args) {
        int i = 1;
        i = i++;
        System.out.println(i);
        int j = i++;
        System.out.println(i);
        int k = i + ++i * i++;  // 2 + 3 * 3

        System.out.println("i= " + i);  //4
        System.out.println("j= " + j);  //1
        System.out.println("k= " + k);  //11

        int a=1,b=0;
        b=a++;  //先赋值b=a,后运算a=a+1,所以结果是b==1
        System.out.println(b);
        System.out.println(a);
        System.out.println(a++ * ++a);
    }

}
