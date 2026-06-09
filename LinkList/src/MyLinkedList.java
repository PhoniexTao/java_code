import java.util.Objects;

public class MyLinkedList<T> implements IList<T> {

    private static class ListNode<T>{
        T val;
        ListNode<T> next;
        ListNode<T> prev;

        public ListNode(T val) {
            this.val = val;
        }
    }
    ListNode<T> head;
    ListNode<T> last;
    int size = 0;
    @Override
    public void addFirst(T data) {
        ListNode<T> newHead = new ListNode<>(data);
        //插入节点考虑头为空的情况
        if(head == null){
            head = newHead;
            last = newHead;
        }else{
            newHead.next = head;
            head.prev = newHead;
            head = newHead;
        }
        size++;
    }

    @Override
    public void addLast(T data) {
        ListNode<T> newNode = new ListNode<>(data);
        if (head == null){
            head = newNode;
            last = newNode;
        }else {
            last.next = newNode;
            newNode.prev = last;
            last = newNode;
        }
        size++;
    }

    @Override
    public void addIndex(int index, T data) {
        if(index < 0 || index > size){
            throw new IndexOutOfBoundsException("Index: " + index + ", Size: " + size);
        }
        if (index == 0){
            this.addFirst(data);
        }else if(index == size){
            this.addLast(data);
        }
        else{
            ListNode<T> newNode = new ListNode<>(data);
            //此处可优化遍历，看index离head近离还是last近
            ListNode<T> preNode = node(index - 1);
            //先连接后面的
            preNode.next.prev = newNode;
            newNode.next = preNode.next;
            //再连接前面的
            preNode.next = newNode;
            newNode.prev = preNode;
            size++;
        }

    }

    private ListNode<T> node(int index) {
        if(index < (size >> 1)){
            ListNode<T> x = head;
            for (int i = 0; i < index; i++) {
                x = x.next;
            }
            return x;
        }else{
            ListNode<T> x = last;
            for (int i = size - 1; i > index; i++) {
                x = x.prev;
            }
            return x;
        }
    }

    @Override
    public void removeFirst() {
        //处理无节点的情况
        if(head == null){
            throw new IndexOutOfBoundsException("remove fail");
        }
        //只有一个节点的情况：
        if (size == 1){
            head = null;
            last = null;
        }else{
            head = head.next;             // 头节点后移
            head.prev = null;
        }
        size--;
    }

    @Override
    public void removeLast() {
        //处理无节点的情况
        if(head == null){
            throw new IndexOutOfBoundsException("remove fail");
        }
        //处理只有一个节点的情况：
        if(size == 1){
            head = null;
            last = null;
        }else{
            ListNode<T> preNode = last.prev;
            preNode.next = null;
            last = preNode;
        }
        size--;

    }

    @Override
    public boolean contains(T data) {
        ListNode<T> cur = head;
        while (cur != null){
            if(Objects.equals(cur.val,data)){
                return true;
            }
            cur = cur.next;
        }
        return false;
    }

    @Override
    public void remove(T key) {
        if (head == null) return;
        if (Objects.equals(head.val, key)) {
            removeFirst();
            return;
        }
        if (Objects.equals(last.val, key)) {
            removeLast();
            return;
        }
        ListNode<T> cur = head.next; // 跳过已检查的头
        while (cur != null && cur != last) { // 也可不加 last 判断，因为 last 已排除
            if (Objects.equals(cur.val, key)) {
                cur.prev.next = cur.next;
                cur.next.prev = cur.prev;
                size--;
                return;
            }
            cur = cur.next;
        }
    }

    @Override
    public void removeAll(T key) {
        // 1. 循环删除头节点
        while (head != null && Objects.equals(head.val, key)) {
            head = head.next;
            if (head != null) head.prev = null;
            else last = null;
            size--;
        }
        if (head == null) return; // 全部删完

        // 2. 循环删除尾节点（此时头已确定非匹配）
        while (last != null && Objects.equals(last.val, key)) {
            last = last.prev;
            if (last != null) last.next = null;
            // 注意：头已经在步骤1中处理，不会因为删除尾而变空（因为 head != null）
            size--;
        }

        // 3. 遍历中间节点（不包括头尾）
        ListNode<T> cur = head.next;
        while (cur != null && cur != last) {
            if (Objects.equals(cur.val, key)) {
                cur.prev.next = cur.next;
                cur.next.prev = cur.prev;
                size--;
            }
            cur = cur.next;
        }
    }

    @Override
    public void display() {
        ListNode<T> cur = head;
        while (cur != null){
            System.out.print(cur.val + " ");
            cur = cur.next;
        }
        System.out.println();
    }

    @Override
    public void clear() {
        head = null;
        last = null;
        size = 0;
    }

    @Override
    public void set(int index, T data) {
        if (index < 0 || index >= size){
            throw new IndexOutOfBoundsException("set fail");
        }
        ListNode<T> cur = node(index);
        cur.val = data;
    }
}

