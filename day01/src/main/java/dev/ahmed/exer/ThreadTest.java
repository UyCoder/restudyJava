package dev.ahmed.exer;

/**
 * @author Ahmed Bughra
 * @create 2022-10-04  11:47 PM
 *
 * Thread class has some methods below
 *    -  void start()
 *    -  run()
 *    -  String getName()
 *    -  void setName(String name)
 *    -  static Thread.currentThread()
 *    -  static void yield()
 *    -  join()
 *    -  static void sleep(long millis)
 *    -  stop()
 *    -  boolean isAlive()
 */
class HelloThread extends Thread {
    @Override
    public void run() {
        for (int i = 0; i < 100; i++) {
            if (i % 2 == 0) {
                System.out.println(Thread.currentThread().getName()+ i);
            }

            if (i % 20 == 0) {
                this.yield();
            }
    }
}

}
public class ThreadTest {
    public static void main(String[] args) {
        HelloThread test = new HelloThread();
        test.setName("threadName: ");
        test.start();
        for (int i = 0; i < 100; i++) {
            if (i % 2 == 0) {
                System.out.println(Thread.currentThread().getName()+ i);
            }
        Thread.currentThread().setName("mainThreadName: ");
        for (int j = 0; j < 100; j++) {
            if (j % 2 == 0) {
                System.out.println(Thread.currentThread().getName()+ j);
            }
    }
}}}
