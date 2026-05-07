package Thread;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

// 实现一个固定线程个数的线程池
class MyThreadPool {
    private BlockingQueue<Runnable> queue = null;
    public MyThreadPool(int n) {
        // 初始化线程池，创建固定个数的线程
        // 这里使用ArrayBlockingQueue作为任务队列, 容量为1000
        queue = new ArrayBlockingQueue<>(1000);

        // 创建 N 个线程
        for (int i = 0; i < n; i++) {
            Thread t = new Thread(() -> {
                try {
                    while (true) {
                        Runnable task = queue.take();
                        task.run();
                    }
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            });
            // t.setDaemon(true);
            t.start();
        }
    }

    public void submit(Runnable task) throws InterruptedException {
        // 将任务放入队列中
        queue.put(task);
    }
}

public class Demo9 {
    public static void main(String[] args) throws InterruptedException {
        MyThreadPool pool = new MyThreadPool(10);

        // 向线程池提交任务
        for (int i = 0; i < 100; i++) {
            int id = i;
            pool.submit(() -> {
                System.out.println(Thread.currentThread().getName() + " id=" + id);
            });
        }
    }
}
