package dev.ahmed;

/**
 * @author Ahmed Bughra
 * @create 2022-10-15  4:23 PM
 */

class Window2 extends Thread{
    private static int ticket =    100;

    @Override
    public void run() {
        while (true) {
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

