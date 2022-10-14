package dev.ahmed.exer;

/**
 * @author Ahmed Bughra
 * @create 2022-10-04  11:33 PM
 *
 * exercise:
 *      makce two thread: one thread print all odd numbers in 100
 *      and one thread print even numbers in 100
 *
 * Thread priorities
     * MAX_PRIORITY: 10
     * MIN_PRIORITY: 1
     * NORMAL_PRIORITY: 5
 * getPriority()
 * setProperty()
 */
public class ThreadDemo {
    public static void main(String[] args) {
        MyThreadEven m1 = new MyThreadEven();
        MyThreadOdd m2 = new MyThreadOdd();

        m1.setPriority(Thread.MAX_PRIORITY);
        m2.setPriority(Thread.MIN_PRIORITY);
        m1.start();
        m2.start();

        // another way to call Thread start
        new Thread(){
            @Override
            public void run() {
                for (int i = 0; i < 100; i++) {
                    if (i % 2 == 0) {
                        System.out.println("ThreadEven "+Thread.currentThread().getPriority() + i);
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