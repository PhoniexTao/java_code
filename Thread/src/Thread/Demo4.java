package Thread;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

public class Demo4 {
    public static void main(String[] args) throws InterruptedException {
        BlockingQueue<String> queue = new LinkedBlockingQueue<>(100);

        //put 和take才有阻塞功能 ，offer和poll没有阻塞功能
        for (int i = 0;i < 100;i++){
            queue.put("aaa");
        }
        System.out.println("队列已满");

        queue.put("aaa");
        System.out.println("再次尝试put元素");
        String elem = queue.take();
        System.out.println(elem);
    }
}
