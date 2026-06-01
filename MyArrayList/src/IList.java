public interface IList<T> {
    //尾插元素

    public void add(T data);

    //指定插入元素
    public void add(int pos,T data);
    //判定是否包含元素
    public boolean contains(T data);
    //查找某个元素对应的位置
    public int indexOf(T toFind);
    //读取某个位置的元素
    public T get(int pos);
    //与数组中某个位置的值进行替换
    public void set(int pos,T data);
    //删除指定元素
    public void remove(T del);
    //清空顺序表
    public void clear();
    //打印顺序表
    public void display();
    //返回元素个数
    public int size();


    //额外拓展 ：

    //头插元素
    public void addFirst(T data);
    //头删元素
    public void removeFirst();
    //尾删元素
    public void removeLast();
}

