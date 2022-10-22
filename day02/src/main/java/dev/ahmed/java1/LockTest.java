package dev.ahmed.java1;

import java.util.concurrent.locks.ReentrantLock;

/**
 * @author Ahmed Bughra
 * @create 2022-10-22  10:19 AM
 *
 * Secure thread : Lock
 *
 * Difference between synchronized and Lock class
 *          1. synchronized unlock automatically
 *          2. Lock class need to be lock and unlock manually
 *
 *
 */

class Window implements Runnable {

    private int ticket = 100;
    // 1. new create ReentrantLock object
    private ReentrantLock lock = new ReentrantLock(true);

    @Override
    public void run() {
        while (true) {
            try {
                // 2. call lock() method
                lock.lock();
                if (ticket > 0 ){

                    try {
                        Thread.sleep(100);
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }


                    System.out.println(Thread.currentThread().getName() + " Ticke No. = " + ticket);
                    ticket --;
                } else{
                    break;
                }
            }finally {
                // 3. unlock the lock() method
                lock.unlock();
            }

        }

    }
}
public class LockTest {
    public static void main(String[] args) {
        Window w = new Window();

        Thread t1 = new Thread(w);
        Thread t2 = new Thread(w);
        Thread t3 = new Thread(w);

        t1.setName("window1");
        t2.setName("window2");
        t3.setName("window3");

        t1.start();
        t2.start();
        t3.start();
    }


}
