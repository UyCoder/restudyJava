package dev.ahmed;

/**
 * @author Ahmed Bughra
 * @create 2022-10-15  4:23 PM
 *
 *  Use synchronized method to achieve Thread class's security problem.
 *
 */

class Window4 extends Thread{
    private static int ticket =    100;


    @Override
    public void run() {
        while (true) {
            show();
        }
    }
    private static synchronized void show(){ // we need to make static
        // here the lock of synchronized method would be Window4.class
        if (ticket > 0){
            System.out.println(Thread.currentThread().getName() + ": selling, ticket No." + ticket);
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            ticket --;
        }
    }

}
public class WindowTest4 {
    public static void main(String[] args) {
        Window4 test1 = new Window4();
        Window4 test2 = new Window4();
        Window4 test3 = new Window4();

        test1.setName("Window1");
        test2.setName("Window2");
        test3.setName("Window3");

        test1.start();
        test2.start();
        test3.start();

    }
}

