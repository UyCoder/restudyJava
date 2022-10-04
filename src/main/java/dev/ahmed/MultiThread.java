package dev.ahmed;

/**
 * @author Ahmed Bughra
 * @create 2022-10-04  10:00 PM
 *
 * Program - A program refers to the image persisted in the storage or at rest
 * Process - Process means a program is in execution
 * Thread - thread means a segment of a process
 *      - one java class will excute 3 thread
 *          1) main method
 *          2) garbage collection
 *          3) exception handling
 *
 *  Why use multiThread
 *  - make ui more efficient
 *  - increase cpu usage
 *  - make application more efficient
 */
public class MultiThread {
// this is not multiThread
            //    public void method1(String str){
            //        System.out.println(str);
            //    }
            //    public void method2(String str){
            //        method1(str);
            //    }
            //    public static void main(String[] args) {
            //        MultiThread mt = new MultiThread();
            //        mt.method2("hello");
            //    }

// list all odd numbers in 100
    // 1. create class extends to thread
}
class MyThread extends Thread {
    // 2. override run() method of Thread
    @Override
    public void run() {
        for (int i = 0; i < 100; i++){
            if (i % 2 != 0){
                System.out.println(Thread.currentThread().getName()+i);
            }
        }
    }
}
