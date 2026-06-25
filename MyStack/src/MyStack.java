import java.util.Arrays;

public class MyStack<T> {
    public Object[] elem;
    private int usedSize = 0;
    static final int DEFAULT_CAPACITY = 10;
    public MyStack() {
        this.elem = new Object[DEFAULT_CAPACITY];
    }
    public MyStack(int initial){
        this.elem = new Object[initial];
    }
    public void push(T val){
        if(isFull()){
            grow();
        }
        elem[usedSize] = val;
        usedSize++;
    }
    public int size(){
        return this.usedSize;
    }
    private boolean isFull(){
        return usedSize == elem.length;
    }
    private void grow(){
        int oldCapacity = elem.length;
        int newCapacity = oldCapacity == 0 ? DEFAULT_CAPACITY:oldCapacity * 2;
        elem = Arrays.copyOf(elem,newCapacity);
    }
    public T pop(){
        if(isEmpty()){
            throw new RuntimeException();
        }
        usedSize--;
        return (T) elem[usedSize - 1];
    }
    public T peek(){
        if(isEmpty()){
            throw new RuntimeException();
        }
        return (T) elem[usedSize - 1];
    }
    public boolean isEmpty(){
        return usedSize == 0;
    }
}
