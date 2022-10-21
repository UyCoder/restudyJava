package dev.ahmed.java1;

/**
 * @author Ahmed Bughra
 * @create 2022-10-22  2:00 AM
 */
public class BackTest {
}

class Bank {
    private Bank(){}

    private static Bank instance = null;
    public static Bank getInstance() {
        // 1st solution
                    //  not good.
//    //    public synchronized static Bank getInstance() {
//            synchronized (Bank.class) {
//
//                if (instance == null) {
//                    instance = new Bank();
//                }
//                return instance;
//            }

        //  2nd solution
                    // better
                if (instance == null) {
                    synchronized (Bank.class) {
                        if(instance==null){
                            instance = new Bank();
                        }
                    }
                }
        return instance;

        }
}