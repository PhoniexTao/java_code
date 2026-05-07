package Thread;


import java.util.concurrent.atomic.AtomicInteger;

public class Demo12 {
    //使用原子类，替代int
//    public  static int count = 0;;

    private static AtomicInteger count = new AtomicInteger(0);
    public static void main(String[] args) {
        Thread t1 = new Thread(()->{
            for (int i = 0; i < 50000; i++) {
//                count++;
                count.getAndIncrement();
            }
        });
        Thread t2 =new Thread(()->{
            for (int i = 0; i < 50000; i++) {
                count.getAndIncrement();
            }
        });
        t1.start();
        t2.start();
        try {
            t1.join();
            t2.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("Count:" + count.get());
    }


}
