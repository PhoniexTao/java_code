public interface IList<T> {
    //头插
    public void addFirst(T data);
    //尾插
    public void addLast(T data);
    //指定插入
    public void addIndex(int index,T data);
    //头删
    public void removeFirst();
    //尾删
    public void removeLast();
    //是否包含关键字
    public boolean contains(T data);
    //按顺序删除第一个值为key的节点
    public void remove(T key);
    // 删除所有值为key的节点
    public void removeAll(T key);
    //打印链表
    public void display();
    //获取单链表的长度
    //清理链表
    public void clear();
    //修改指定位置的值
    public void set(int index,T data);
}
