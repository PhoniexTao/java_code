import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Objects;

public class MyArrayList<T> implements IList<T>{
    private Object[] elementData;
    static final int DEFAULT_CAPACITY = 10;
    int usedSize = 0;

    public MyArrayList() {
        elementData = new Object[DEFAULT_CAPACITY];
    }
    public MyArrayList(Collection<? extends T> c){
        Object[]a = c.toArray();
        int size = a.length;
        if(size != 0){
            elementData = Arrays.copyOf(a,size,Object[].class);
        }else{
            elementData = new Object[DEFAULT_CAPACITY];
        }
    }
    public MyArrayList(int InitialSize){
        elementData = new Object[InitialSize];
    }

    private void checkPos(int pos){
        if(pos < 0 || pos > usedSize){
            throw new PosIllegal("越界访问");
        }else{
            return;
        }
    }
    private boolean isFull(){
        return usedSize == elementData.length;
    }
    @Override
    public void add(T data) {
        if(isFull()){
            grow();
        }
        elementData[usedSize] = data;
        usedSize++;
    }

    private void grow() {
        int oldCapacity = elementData.length;
        int newCapacity = oldCapacity == 0 ? DEFAULT_CAPACITY : oldCapacity * 2;
        elementData = Arrays.copyOf(elementData, newCapacity);
    }

    @Override
    public void add(int pos, T data) {
        try {
            checkPos(pos);
            if(isFull()){
                grow();
            }
            for (int i = usedSize - 1; i >= pos; i++) {
                elementData[i + 1] = elementData[i];
            }
            elementData[pos] = data;
            usedSize++;
        }catch (PosIllegal e){
            e.printStackTrace();
            throw new IndexOutOfBoundsException("插入位置非法: " + pos);
        }
    }

    @Override
    public boolean contains(T toFind) {
        for (int i = 0; i < usedSize; i++) {
            if (Objects.equals(elementData[i], toFind)) {
                return true;
            }
        }
        return false;
    }

    @Override
    public int indexOf(T toFind) {
        for (int i = 0; i < usedSize; i++) {
            if (Objects.equals(elementData[i], toFind)) {
                return i;
            }
        }
        return -1;
    }
    private void checkPosForAccess(int pos) {
        if (pos < 0 || pos >= usedSize) {
            throw new IndexOutOfBoundsException("访问位置非法: " + pos);
        }
    }
    @Override
    public T get(int pos) {
        try {
            checkPosForAccess(pos);
            return (T) elementData[pos];
        }catch (PosIllegal e){
            e.printStackTrace();
            throw new IndexOutOfBoundsException("获取元素位置非法：" + pos);
        }
    }
    private void setCheckpos(int pos){
        if(pos < 0 || pos >= usedSize){
            throw new PosIllegal("set 位置不合法 "+ pos);
        }
    }
    @Override
    public void set(int pos, T data) {
        try{

            //java中的数组禁止隔空插入数据
            setCheckpos(pos);
            elementData[pos] = data;
            usedSize++;

        }catch (PosIllegal e){
            e.printStackTrace();
            throw new IndexOutOfBoundsException();
        }
    }


    @Override
    public void remove(T del) {
        int aim = -1;
        for (int i = 0; i < usedSize; i++) {
            if(elementData[i].equals(del)){
                aim = i;
                break;
            }
        }
        if(aim != -1){
            for (int i = aim; i < usedSize - 1; i++) {
                elementData[i] = elementData[i + 1];
            }
            usedSize--;
            elementData[usedSize] = null;

        }else{
            return;
        }
    }

    @Override
    public void clear() {
        for (int i = 0; i < usedSize; i++) {
            elementData[i] = null;
        }
        usedSize = 0;
    }

    @Override
    public void display() {
        for (int i = 0; i < usedSize; i++) {
            System.out.println(elementData[i] + " ");
        }
    }

    @Override
    public int size() {
        return usedSize;
    }

    @Override
    public void addFirst(T data) {
        if(isFull()){
            grow();
        }
        for (int i = usedSize; i > 0; i++) {
            elementData[i] = elementData[i - 1];
        }
        elementData[0] = data;
        usedSize++;
    }

    @Override
    public void removeFirst() {
        if (usedSize < 1){
            return;
        }
        for (int i = 0; i < usedSize - 1; i++) {
            elementData[i] = elementData[i + 1];
        }
        elementData[usedSize - 1] = null;
        usedSize--;
    }

    @Override
    public void removeLast() {
        elementData[usedSize - 1] = null;
        usedSize--;
    }
}
