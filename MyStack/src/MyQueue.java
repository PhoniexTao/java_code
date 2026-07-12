import javax.swing.*;
import java.util.Arrays;
import java.util.IllegalFormatCodePointException;
import java.util.NoSuchElementException;

public class MyQueue<T> {
    static class ListNode<T>{
        public T val;
        public ListNode prev;
        public ListNode next;

        public ListNode(T val) {
            this.val = val;
        }
    }
    public ListNode<T> first = null;
    public ListNode<T> last = null;

    public int usedSize = 0;
    public boolean isEmpty(){
        if(first == null){
            return true;
        }
        return false;
     }
    public void offer(T val){
        ListNode<T> newNode = new ListNode<>(val);
        if (isEmpty()){
            first = newNode;
            last = newNode;
        }else{
            last.next = newNode;
            newNode.prev = last;
            last = newNode;
        }
        usedSize++;
    }
    public T poll() {
        if (isEmpty()) {
            throw new NoSuchElementException("Queue is empty");
        }
        T val = first.val;
        first = first.next;
        if (first == null) {
            // 队列已空，last 也要置 null
            last = null;
        } else {
            first.prev = null;  // 只有在 first 不为 null 时才操作
        }
        usedSize--;
        return val;
    }
    public T peek(){
        if(isEmpty()){
            throw new NoSuchElementException("Queue is empty");
        }
        T val = first.val;
        return val;
    }
}
