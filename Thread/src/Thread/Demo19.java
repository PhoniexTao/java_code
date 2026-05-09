package Thread;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Demo19 {
    public static void main(String[] args) throws InterruptedException {
        //现在把10个指令拆成10个部分，每个部分视为是一个“子任务”
//        可以把10个子任务丢到线程池中，让线程执行
//        当然也可以安排10个独立的线程执行

//      构造方法中传入的10表示任务的个数
        CountDownLatch latch = new CountDownLatch(10);
        ExecutorService excutor = Executors.newFixedThreadPool(4);
        for (int i = 0; i < 10; i++) {
            int id = i;
            excutor.submit(()->{
                System.out.println("子任务开始执行:" + id);
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
                System.out.println("子任务结束执行"+ id);
                latch.countDown();
            });
        }
        //这个方法阻塞等待所有的任务结束
        latch.await();
        System.out.println("所有任务执行完毕");
    }
}
