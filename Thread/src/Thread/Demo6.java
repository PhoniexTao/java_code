package Thread;

//模拟实现一个阻塞队列 （非泛型版）
class MyBlockingQueue{
    private String[] data = null;

    private int head = 0;

    private int tail = 0;

    //元素个数
    private int size = 0;

    public MyBlockingQueue(int capacity){
        data  = new String[capacity];
    }
    public void  put(String elem) throws InterruptedException {
        synchronized (this){
            while(size >= data.length){
                //队列满了，需要阻塞
                //阻塞最好用while循环判断，否则可能会被interrupt唤醒
                this.wait();
            }
            data[tail] = elem;
            tail++;
            //循环队列的处理
            if(tail >= data.length){
                tail = 0;
            }
            size++;
            this.notify();
        }

    }
    public String take() throws InterruptedException {
        synchronized (this){
            while (size == 0){
                //队列为空，需要阻塞
//                return null;
                this.wait();
            }
            String ret = data[head];
            head++;
            if(head >= data.length){
                head = 0;
            }
            size--;
            this.notify();
            return ret;
        }

    }
}
public class Demo6 {
    public static void main(String[] args) {
        MyBlockingQueue queue = new MyBlockingQueue(1000);
        Thread producer = new Thread(()->{
           int n = 0;
           while (true){
               try {
                   queue.put(n + "");
                   System.out.println("生产元素" + n);
                   n++;
               } catch (InterruptedException e) {
                   throw new RuntimeException(e);
               }

           }
        });
        Thread consumer = new Thread(()->{
           while (true){
               try {
                   String n = queue.take();
                   System.out.println("消费元素" + n);
               } catch (InterruptedException e) {
                   throw new RuntimeException(e);
               }
           }
        });
        producer.start();;
        consumer.start();
    }
}
