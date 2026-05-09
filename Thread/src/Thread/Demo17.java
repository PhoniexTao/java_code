package Thread;

import java.util.concurrent.Semaphore;

public class Demo17 {
    public static void main(String[] args) throws InterruptedException {
        Semaphore semaphore = new Semaphore(4);
        semaphore.acquire();
        System.out.println("perform a P operation");
        semaphore.acquire();
        System.out.println("perform a P operation");
        semaphore.acquire();
        System.out.println("perform a P operation");
        semaphore.acquire();
        System.out.println("perform a P operation");
        semaphore.release();
        System.out.println("perform a P operation");

    }
}
