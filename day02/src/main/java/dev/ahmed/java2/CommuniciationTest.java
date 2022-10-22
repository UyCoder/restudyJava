package dev.ahmed.java2;

/**
 * @author Ahmed Bughra
 * @create 2022-10-22  10:59 AM
 *
 * we will learn 3 methods for thread in this class
 *      wait()      -- will pause the thread
 *      notify()    -- will start the paused thread
 *      notifyAll() -- will start all the waiting threads
 *
 * Note:
 *      1. Those methods only can be called inside synchronized threads
 *      2. All those methods must be this.
 *                  this.wait() , this.notify() , this.notifyAll()
 *      3. All other methods are in java.lang.Object
 *
 *
 * Interview Questions: Similarities and differences between sleep() and wait()
 *      1. Similarities: Both sleep() and wait() will pause the thread
 *      2. differences : 1) declared places are different. sleep() on Thread class , wait() will on Object class
 *                       2) requirements are different. sleep() can be any circumstances, wait() must be called on synchronized
 *                       3) Not both of then can unlock synchronized lock . sleep() will not unlock, wait() can unlock synchronized
 */

class Number implements Runnable {

    private int number = 1;
    @Override
    public void run() {
        while (true) {
            synchronized (this){
                notify();

                if (number <= 100) {

                    try {
                        Thread.sleep(10);
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }

                    System.out.println(Thread.currentThread().getName() + ":" + number);
                    number++;

                    try {
                        wait();
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }

                }else {
                    break;
                }
            }
        }

    }
}

public class CommuniciationTest {
    public static void main(String[] args) {
        Number number = new Number();
        Thread t1 = new Thread(number);
        Thread t2 = new Thread(number);

        t1.setName("thread1");
        t2.setName("thread2");

        t1.start();
        t2.start();

    }
}
