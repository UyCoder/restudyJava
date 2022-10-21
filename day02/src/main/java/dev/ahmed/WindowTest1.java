package dev.ahmed;

/**
 * @author Ahmed Bughra
 * @create 2022-10-10  11:26 PM
 *
 * Java thread  is not secure. So we have solution named Synchronous
 *  We could take the specific code to the inside of synchronized(){}
 *  - synchronized(lock){} has lock to open
 *  - when we use synchronized(){} that means only one thread is allowed to access every time
 *          - this means synchronized just like single thread is executed
 *
 */

class Window1 implements Runnable {
    private int ticket = 100;
    Object lock = new Object(); // this lock object should be declared here

    @Override
    public void run() {
        while (true) {
            synchronized (lock) {
                        if (ticket > 0) {
                            try {
                                Thread.sleep(100);
                            } catch (InterruptedException e) {
                                throw new RuntimeException(e);
                            }

                            System.out.println(Thread.currentThread().getName() + " -t- " + ticket);
                            ticket--;
                        } else {
                            break;
                        }
            }
        }
    }
}
public class WindowTest1 {
    public static void main(String[] args) {
        Window1 w = new Window1();

        Thread t1 = new Thread(w);
        Thread t2 = new Thread(w);
        Thread t3 = new Thread(w);

        t1.setName("windwo1");
        t2.setName("windwo2");
        t3.setName("windwo3");

        t1.start();
        t2.start();
        t3.start();
    }
}
