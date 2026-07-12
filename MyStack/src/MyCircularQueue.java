public class MyCircularQueue<T> {
//    循环队列的成员变量有三个，要记得需要front记录真正的顺序表头
    public int front;
    public int rear;
    public Object[] elem;

    public MyCircularQueue(int k) {
        elem = new Object[k];
    }
    public boolean isFull(){
        return (rear + 1)%elem.length == front;
    }
    //入队列：
    public boolean enQueue(T value){
        if(isFull()){
            return false;
        }
        elem[rear] = value;
        rear = (rear + 1) % elem.length;
        return true;
    }
    public boolean isEmpty(){
        if (rear == front){
            return true;
        }
        return false;
    }
    //出队列:
    public boolean deQueue(){
        if(isEmpty()){
            return false;
        }
        front = (front + 1) % elem.length;
        return true;
    }
    //得到队头元素：
    public T Front(){
        if(isEmpty()){
            return null;
        }
        return (T) elem[front];
    }
    //得到队尾元素：
    public  T Rear(){
        if(isEmpty()){
            return null;
        }
        //这里的rear指针越界问题进行处理：
        int index = (rear == 0) ? elem.length - 1 : rear-1;
        return (T) elem[index];
    }


}
