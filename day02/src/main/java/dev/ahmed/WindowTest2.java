package dev.ahmed;

/**
 * @author Ahmed Bughra
 * @create 2022-10-15  4:23 PM
 *
 *
 * We have 2 ways to use lock of the synchronized()
 *  1. We could use this for lock of synchronized, this way we don't have to worry about locking.
 *          synchronizer(this){}       - we don't need to create extra lock object
 *  2. we could use Window2.class for lock of synchronized
 *          synchronized(Window2.class){}   - Window2.class can be used as object
 */

class Window2 extends Thread{
    private static int ticket =    100;
    private static Object lock = new Object(); // this object should be static. because all tree object should be use only one object.


    @Override
    public void run() {
        while (true) {
            synchronized (lock) { // we could use this inside parathesis
                // synchronized(this) { // this here is the single object declared from Window2
                if (ticket > 0){
                    System.out.println(getName() + ": selling, ticket No." + ticket);
                    try {
                        Thread.sleep(100);
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                    ticket --;
                }else{
                    break;
                }
            }
        }
    }
}
public class WindowTest2 {
    public static void main(String[] args) {
        Window2 test1 = new Window2();
        Window2 test2 = new Window2();
        Window2 test3 = new Window2();

        test1.setName("Window1");
        test2.setName("Window2");
        test3.setName("Window3");

        test1.start();
        test2.start();
        test3.start();

    }
}

