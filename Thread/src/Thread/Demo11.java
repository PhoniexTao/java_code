package Thread;

// 这样的写法基于抽象类的方式定义 MyTimerTask
// 这样的定义虽然确实可以, 写起来有点麻烦.
// 还有另外的写法.
//abstract class MyTimerTask implements Runnable {
//    @Override
//    public abstract void run();
//}

import java.util.PriorityQueue;
import java.util.concurrent.Executors;

class MyTimerTask implements Comparable<MyTimerTask> {
    private Runnable task;
    // 记录任务要执行的时刻
    private long time;

    public MyTimerTask(Runnable task, long time) {
        this.task = task;
        this.time = time;
    }

    @Override
    public int compareTo(MyTimerTask o) {
        return (int) (this.time - o.time);
        // return (int) (o.time - this.time);
    }

    public long getTime() {
        return time;
    }

    public void run() {
        task.run();
    }
}

// 自己实现一个定时器
class MyTimer {
    private PriorityQueue<MyTimerTask> queue = new PriorityQueue<>();

    // 直接使用 this 作为锁对象, 当然也是 ok 的
    private Object locker = new Object();

    public void schedule(Runnable task, long delay) {
        synchronized (locker) {
            // 以入队列这个时刻作为时间基准.
            MyTimerTask timerTask = new MyTimerTask(task, System.currentTimeMillis() + delay);
            queue.offer(timerTask);
            locker.notify();
        }
    }

    public MyTimer() {
        // 创建一个线程, 负责执行队列中的任务
        Thread t = new Thread(() -> {
            try {
                while (true) {
                    synchronized (locker) {
                        // 取出队首元素
                        // 还是加上 while
                        while (queue.isEmpty()) {
                            // 这里的 sleep 时间不好设定!!
                            locker.wait();
                        }
                        MyTimerTask task = queue.peek();
                        if (System.currentTimeMillis() < task.getTime()) {
                            // 当前任务时间, 如果比系统时间大, 说明任务执行的时机未到
                            locker.wait(task.getTime() - System.currentTimeMillis());
                        } else {
                            // 时间到了, 执行任务
                            task.run();
                            queue.poll();
                        }
                    }
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });
        t.start();
    }
}

public class Demo11 {
    public static void main(String[] args) {
        MyTimer timer = new MyTimer();
        timer.schedule(new Runnable() {
            @Override
            public void run() {
                System.out.println("hello 3000");
            }
        }, 3000);
        timer.schedule(new Runnable() {
            @Override
            public void run() {
                System.out.println("hello 2000");
            }
        }, 2000);
        timer.schedule(new Runnable() {
            @Override
            public void run() {
                System.out.println("hello 1000");
            }
        }, 1000);

        Executors.newScheduledThreadPool(4);
    }
}