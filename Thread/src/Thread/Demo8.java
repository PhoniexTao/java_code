package Thread;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import static java.util.concurrent.Executors.newFixedThreadPool;

public class Demo8 {
    public static void main(String[] args) {
        //线程池的工厂类
        ExecutorService threadPoll = Executors.newFixedThreadPool(4);        //固定数量的线程池
//        ExecutorService threadPoll = Executors.newCachedThreadPool();    //线程可以增加直到最大值

        for (int i = 0; i < 1000; i++) {
            int id = i;
            threadPoll.submit(()->{
                System.out.println("hello" + id + "," + Thread.currentThread().getName());
            });
        }
    }
}
