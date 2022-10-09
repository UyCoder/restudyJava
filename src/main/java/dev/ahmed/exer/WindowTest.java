package dev.ahmed.exer;

import java.awt.*;

/**
 * @author Ahmed Bughra
 * @create 2022-10-06  11:46 PM
 *
 * example:
 *      3 ticket selling windows, totla ticket 100
 */

class Window extends Thread{
    private static int ticket =    100;

    @Override
    public void run() {
        while (true) {
            if (ticket > 0){
                System.out.println(getName() + ": selling, ticket No." + ticket);
                ticket --;
            }else{
                break;
            }
        }
    }
}
public class WindowTest {
    public static void main(String[] args) {
        Window test1 = new Window();
        Window test2 = new Window();
        Window test3 = new Window();

        test1.setName("Window1");
        test2.setName("Window2");
        test3.setName("Window3");

        test1.run();
        test2.run();
        test3.run();

    }
}
