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
    public void  put(String elem){
        synchronized (this){
            if(size >= data.length){
                //队列满了，需要阻塞
                return;
            }
            data[tail] = elem;
            tail++;
            //循环队列的处理
            if(tail >= data.length){
                tail = 0;
            }
            size++;
        }

    }
    public String take(){
        synchronized (this){
            if(size == 0){
                //队列为空，需要阻塞
                return null;
            }
            String ret = data[head];
            head++;
            if(head >= data.length){
                head = 0;
            }
            size--;
            return ret;
        }

    }
}
public class Demo6 {
    public static void main(String[] args) {

    }
}
