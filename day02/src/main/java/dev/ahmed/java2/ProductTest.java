package dev.ahmed.java2;

/**
 * @author Ahmed Bughra
 * @create 2022-10-22  12:16 PM
 *
 * The usage example of thread notify
 *          Producter / Consumer example
 *
 */

class Clerk{
    private int productCount = 0;

    public synchronized void produceProduct() {


        if (productCount < 20) {
            productCount++;
            System.out.println(Thread.currentThread().getName() + " start to produce the product No.  " + productCount);
            notify();
        }else {
            //TODO:
            try {
                wait();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }

    }

    public synchronized void consumeProduct() {
        if(productCount > 0) {
            System.out.println(Thread.currentThread().getName() + " sart to consume the product No. " + productCount);
            productCount--;
            notify();
        }else {
            //TODO:
            try {
                wait();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }
}

class Producter extends Thread{
    private Clerk clerk;

    public Producter(Clerk clerk) {
        this.clerk = clerk;
    }

    @Override
    public void run() {
        System.out.println(Thread.currentThread().getName()+" Start to produce... ");

        while (true) {
            try {
                Thread.sleep(10);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }

            clerk.produceProduct();
        }

    }
}
class Consumer extends Thread {
    private Clerk clerk;
    public Consumer(Clerk clerk) {
        this.clerk = clerk;
    }

    @Override
    public void run() {
        System.out.println(Thread.currentThread().getName()+" Start to consume... ");

        while (true) {
            try {
                Thread.sleep(25);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }

            clerk.consumeProduct();
        }
    }
}

public class ProductTest {
    public static void main(String[] args) {
        Clerk clerk = new Clerk();

        Producter p1 = new Producter(clerk);
        p1.setName("Producter1");

        Consumer c1 = new Consumer(clerk);
        c1.setName("Concumer1");

        Consumer c2 = new Consumer(clerk);
        c2.setName("Concumer2");

        p1.start();
        c1.start();
        c2.start();
    }
}

