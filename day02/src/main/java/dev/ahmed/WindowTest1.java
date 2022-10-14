package dev.ahmed;

/**
 * @author Ahmed Bughra
 * @create 2022-10-10  11:26 PM
 */

class Window1 implements Runnable {
    private int ticket = 100;

    @Override
    public void run() {
        while (true) {
            if (ticket > 0){

                System.out.println(Thread.currentThread().getName() + " -t- "+ticket );
                try {
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
                ticket --;
            }else {
                break;
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
