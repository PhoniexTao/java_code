package Thread;

public class Demo1 {
    public static void main(String[] args) throws InterruptedException {
        Object locker1 = new Object();
        Object locker2 = new Object();
        Object locker3 = new Object();

        Thread t1 = new Thread(() -> {
            try {
                for (int i = 0; i < 10; i++) {
                    synchronized (locker1) {
                        locker1.wait();
                    }
                    System.out.print("A");
                    synchronized (locker2) {
                        locker2.notify();
                    }
                }
            } catch (InterruptedException e) {
                throw new RuntimeException();
            }
        });
        Thread t2 = new Thread(() -> {
            try {
                for (int i = 0; i < 10; i++) {
                    synchronized (locker2) {
                        locker2.wait();
                    }
                    System.out.print("B");
                    synchronized (locker3) {
                        locker3.notify();
                    }
                }
            } catch (InterruptedException e) {
                throw new RuntimeException();
            }
        });
        Thread t3 = new Thread(() -> {
            try {
                for (int i = 0; i < 10; i++) {
                    synchronized (locker3) {
                        locker3.wait();
                    }
                    System.out.println("C");
                    synchronized (locker1) {
                        locker1.notify();
                    }
                }
            } catch (InterruptedException e) {
                throw new RuntimeException();
            }
        });
        t1.start();
        t2.start();
        t3.start();

        // 主线程中, 先通知一次 locker1, 让上述逻辑从 t1 开始执行
        // 需要确保上述三个线程都执行到 wait, 再进行 notify
        Thread.sleep(1000);
        synchronized (locker1) {
            locker1.notify();
        }
    }
}