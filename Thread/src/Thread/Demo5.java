package Thread;

import com.sun.source.tree.Tree;

import java.util.concurrent.BlockingDeque;
import java.util.concurrent.LinkedBlockingDeque;

public class Demo5 {
    public static void main(String[] args) {
        //至少生产者一个线程，消费者一个线程
        BlockingDeque<Integer> queue = new LinkedBlockingDeque<>(1000);
        Thread producer = new Thread(()->{
            int n = 0;
            while (true) {
                try {
                    queue.put(n);
                    System.out.println("生产元素" + n);
                    n++;

                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
        },"producer");

        Thread consumer = new Thread(()->{
            while (true){
                try {
                    Integer n = queue.take();
                    System.out.println("消费元素" + n);
                    Thread.sleep(1000);

                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
        },"consumer");
        producer.start();
        consumer.start();
    }
}
