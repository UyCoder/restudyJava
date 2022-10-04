package dev.ahmed.exer;

import java.util.Map;

/**
 * @author Ahmed Bughra
 * @create 2022-10-04  11:33 PM
 *
 * exercise:
 *      makce two thread: one thread print all odd numbers in 100
 *      and one thread print even numbers in 100
 *
 */
public class ThreadDemo {
    public static void main(String[] args) {
        MyThreadEven m1 = new MyThreadEven();
        MyThreadOdd m2 = new MyThreadOdd();

        m1.start();
        m2.start();

        // another way to call Thread start
        new Thread(){
            @Override
            public void run() {
                for (int i = 0; i < 100; i++) {
                    if (i % 2 == 0) {
                        System.out.println("ThreadEven " + i);
                    }
                }
            }
        }.start();
    }
}

class MyThreadEven extends Thread {
    @Override
    public void run() {
        for (int i = 0; i < 100; i++) {
            if (i % 2 == 0) {
                System.out.println("ThreadEven " + i);
            }
        }
    }
}

class MyThreadOdd extends Thread {
    @Override
    public void run() {
        for (int i = 0; i < 100; i++) {
            if (i % 2 != 0) {
                System.out.println("ThreadOdd " + i);
            }
        }
    }
}