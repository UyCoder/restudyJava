package dev.ahmed.java;

public class MultiThreadTest {
    public static void main(String[] args) {
        // 3. create subclass of Thread class
        MyThread t1 = new MyThread();
        // 4. call start method of Thread :
                    // start(): Causees this thread to begin execution; the JVM will calls the run method of this thread
        t1.start();
                // 1) we can not call run method of this thread because it will not executed as multiThread
//        t1.run();
                // 2) start() only called once, second time will response exception
//        t1.start();
        MyThread t2 = new MyThread();
        t2.start();


        // this for loop will be executed in main thread
        for (int i = 0; i < 100; i++){
            if (i % 2 == 0){
                System.out.println(Thread.currentThread().getName()+i);
            }
        }

        //
    }
}
