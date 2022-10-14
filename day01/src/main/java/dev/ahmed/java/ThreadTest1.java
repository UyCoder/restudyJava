package dev.ahmed.java;

/**
 * @author Ahmed Bughra
 * @create 2022-10-10  1:21 AM
 *
 * scond method for creating multiThread: Runnable
 */

class Mthread implements Runnable {
    @Override
    public void run() {
        for (int i = 0; i <100; i++) {
            if (i % 2 == 0) {
                System.out.println(Thread.currentThread().getName()+i);
            }
        }
    }
}


public class ThreadTest1 {
    public static void main(String[] args) {

        Mthread mThread= new Mthread();
        Thread t1 = new Thread(mThread);
        t1.setName("test1-");
        t1.start();

        Thread t2 = new Thread(mThread);
        t2.setName("test2-");
        t2.start();
    }
}
