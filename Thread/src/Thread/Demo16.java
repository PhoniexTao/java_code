package Thread;

import java.util.concurrent.locks.ReentrantLock;

public class Demo16 {
    private static int count  = 0;

    public static void main(String[] args) throws InterruptedException {
        ReentrantLock locker = new ReentrantLock();
        Thread t1 = new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i < 50000; i++) {
                    locker.lock();
                    try{
                        count++;
                    } finally {
                        locker.unlock();
                    }
                }
            }
        });
        Thread t2 = new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i < 50000; i++) {
                    locker.lock();
                    try{
                        count++;
                    } finally {
                        locker.unlock();
                    }
                }
            }
        });
        t1.start();
        t2.start();
        t1.join();
        t2.join();

        System.out.println(count);
    }
}
