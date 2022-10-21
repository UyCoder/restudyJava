package dev.ahmed;

/**
 * @author Ahmed Bughra
 * @create 2022-10-22  1:37 AM
 *
 * User synchronized to achive Runnable API's secure problem
 *
 *
 */
class Window3 implements Runnable {
    private int ticket = 100;

    @Override
    public void run() {
        while (true) {
            show();
        }
    }

    private synchronized void show() { // we could directly create synchronized method
//        synchronized (this) {
            if (ticket > 0) {
                try {
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }

                System.out.println(Thread.currentThread().getName() + " -t- " + ticket);
                ticket--;
            }

        }
//    }
}
public class WindowTest3 {
    public static void main(String[] args) {
        Window3 w = new Window3();

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
