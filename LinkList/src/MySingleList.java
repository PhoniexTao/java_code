import java.util.Objects;

public class MySingleList<T> implements IList<T> {

    ListNode head;
    int size;
    private static class ListNode<T>{
        T val;
        ListNode next;

        public ListNode(T val) {
            this.val = val;
        }
    }

    @Override
    public void addFirst(T data) {
        //头插:思考头为空的情况，发现头为空和头不为空的情况可以合并，结果是对的
        ListNode<T> newHead = new ListNode<>(data);
        newHead.next = head;
        head = newHead;
        size++;
    }

    @Override
    public void addLast(T data) {
        //尾插:思考头为空的情况：避免空指针异常
        if(head == null){
            head = new ListNode<>(data);
            return;
        }
        //头不为空的情况：
        ListNode<T> newNode = new ListNode<>(data);
        ListNode<T> cur = head;
        while (cur.next != null){
            cur = cur.next;
        }
        cur.next = newNode;
        size++;
    }

    @Override
    public void addIndex(int index, T data) {
        //先判断index是否合理
        if (index < 0 || index > size){
            throw new IndexOutOfBoundsException("Index: " + index + ", Size: " + size);
        }
        //考虑头插，顺便处理头节点为空的情况：
        if (index == 0){
            ListNode<T> newHead = new ListNode<>(data);
            newHead.next = head;
            head = newHead;
            size++;
            return;
        }
        ListNode<T> cur = head;
        while (--index != 0){
            cur = cur.next;
        }
        ListNode<T> newNode = new ListNode<>(data);
        newNode.next = cur.next;
        cur.next = newNode;
        size++;
    }

    @Override
    public void removeFirst() {
        //头删，要保证有节点可删除
        if(size == 0){
            throw new IndexOutOfBoundsException( "size: " + size);
        }
        head = head.next;
    }

    @Override
    public void removeLast() {
        //尾删：也要保证尾部有节点可删除
        if(size == 0){
            throw new IndexOutOfBoundsException("size :" + size);
        }
        if(size == 1){
            head = null;
        }else{
            ListNode<T> cur = head;
            while (cur.next.next != null){
                cur = cur.next;
            }
            cur.next = null;
        }
        size--;
    }

    @Override
    public boolean contains(T data) {
        if(head == null){
            return false;
        }
        ListNode<T> cur = head;
        while (cur != null){
            if(Objects.equals(cur.val, data)){
                return true;
            }
            cur = cur.next;
        }
        return false;

    }

    @Override
    public void remove(T key) {
        if(head == null){
            return;
        }
        ListNode<T> cur = head.next;
        ListNode<T> prev = head;
        //处理头结点
        if(Objects.equals(head.val, key)){
            head = head.next;
            size--;
            return;
        }
        while (cur != null){

            if (Objects.equals(cur.val,key)){
                prev.next = cur.next;
                size--;
                break;
            }
            prev = cur;
            cur = cur.next;
        }
    }

    @Override
    public void removeAll(T key) {
        if(head == null){
            return;
        }
        //处理头结点：
        while (head != null && Objects.equals(head.val, key)) {
            head = head.next;
            size--;
        }
        if (head == null) return; // 链表已空

        ListNode<T> cur = head.next;
        ListNode<T> prev = head;
        while (cur != null){
            if(Objects.equals(cur.val,key)){
                prev.next = cur.next;
                size--;
            }else{
                //没有删除节点时，prev才会更新，不然prev会移到要删除的节点上
                prev = cur;
            }
            cur = cur.next;
        }
    }

    @Override
    public void display() {
        ListNode<T> cur = head;
        while (cur != null){
            System.out.println(cur.val);
            cur = cur.next;
        }
    }



    @Override
    public void clear() {
        head = null;
        size = 0;
    }

    @Override
    public void set(int index,T data){
        if (index < 0 || index >= this.size){
            return;
        }
        ListNode<T> cur = head;
        while (index-- != 0){
            cur = cur.next;
        }
        cur.val = data;
    }
}
