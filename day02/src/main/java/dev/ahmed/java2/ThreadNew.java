package dev.ahmed.java2;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

/**
 * @author Ahmed Bughra
 * @create 2022-10-22  2:09 PM
 *
 * 3rd way to make thread : Callable API (JDK5.0 new feature)
 *      we have 6 steps to use callable API
 */
// 1. Create class that implements Callable Class
class NumThreads implements Callable{
// 2. override call methods
    @Override
    public Object call() throws Exception {
        int sum = 0;
       for (int i = 0; i <= 100; i++){
           if (i%2 == 0){
               System.out.println(i);
               sum += i;
           }
       } return sum;
    }
}

public class ThreadNew  {
    public static void main(String[] args) {
// 3. create callable object
        NumThreads numThreads = new NumThreads();
// 4. callable object path to FutureTask constructor, and create futureTask object
        FutureTask futureTask = new FutureTask(numThreads);
// 5. make thread object then call start function
        new Thread(futureTask).start();
        try {
// 6. get callable object's call() method's return value
            // .get() will return a FutureTask constructed from Callable'is call()
            Object sum = futureTask.get();
            System.out.println("Sum is : "+sum);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        } catch (ExecutionException e) {
            throw new RuntimeException(e);
        }
    }
}
