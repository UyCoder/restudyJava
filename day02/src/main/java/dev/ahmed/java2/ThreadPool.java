package dev.ahmed.java2;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadPoolExecutor;

/**
 * @author Ahmed Bughra
 * @create 2022-10-22  2:54 PM


 * 4st way to create thread
 *
 * The benefits to use threadPool to create thread are :
 *      1. less time to crate threads
 *      2. less memory
 *      3. easy to configure
     *          corePoolSize     -- core pool size
     *          maximumPoolSize  -- maximum pool size
     *          keepAliveTime     -- keepAlive time
 *
 *
 */

class numberThread implements Runnable {

    @Override
    public void run() {
        for (int i = 0; i < 100; i++) {
            if (i%2 == 0) {
                System.out.println(Thread.currentThread().getName()+i);
            }
        }
    }
}

class numberThread1 implements Runnable {

    @Override
    public void run() {
        for (int i = 0; i < 100; i++) {
            if (i%2 != 0) {
                System.out.println(Thread.currentThread().getName()+i);
            }
        }
    }
}
public class ThreadPool {
    public static void main(String[] args) {
        // 1. submit thread number to the pool
        ExecutorService service = Executors.newFixedThreadPool(10);
//        ThreadPoolExecutor service1 = (ThreadPoolExecutor) service;

        System.out.println(service.getClass());

//        service1.setCorePoolSize(15);
//        service1.setKeepAliveTime(15);
//        service1.setMaximumPoolSize(15);


        // 2. execute thread. Runnable or Callable
        service.execute(new numberThread()); // for Runnable
        service.execute(new numberThread1());
//        service.submit(Callable callable); // for Callable

        // 3. shutdown the pool
        service.shutdown();

    }
}
