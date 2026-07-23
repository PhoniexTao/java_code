import java.util.Arrays;
import java.util.Objects;

public class MyHeap<T extends Comparable<T>> {
    public Object[] elem;
    public int usedSize;

    public MyHeap(){
        elem = new Object[10];
    }
    public void initElem(T[] arr){
        for (int i = 0; i < arr.length; i++) {
            elem[i] = arr[i];
        }
        usedSize = 10;
    }
    //向下调整建堆
    public void creatHeap(){
        //这部分的难点在边界处理的逻辑：
        //首先要分清楚建堆 和 向下调整 这两个动作的目的

        //在这里的建堆循环中，边界条件重在建堆，我们要利用向下调整这个方法来建堆
        //向下调整建堆的要求是：要从最后一个非叶子结点来开始调整，逐步向上调整，到下标为 0 ，所以边界条件如下：

        for (int parent = (usedSize - 1 - 1) / 2; parent >= 0 ; parent--) {
            shiftDown(parent,usedSize);
        }
    }


    //记忆向下调整传入的参数为父节点
    //向下调整时间复杂度：O(N)
    private void shiftDown(int parent, int usedSize) {
        //向下调整：每一次向下调整之后如果成功置换，则将子结点位置作为新的parent结点再次进行调整
        //所以要注意该调整的边界情况为子节点是否超过数组的最大值
        int child = parent * 2 + 1;
        while (child < usedSize){
            if(child + 1 < usedSize && ((T)elem[child + 1]).compareTo((T)elem[child]) > 0){
                child++;
            }
            if(((T)elem[child]).compareTo((T)elem[parent]) > 0){
                swap(elem,child,parent);
                parent = child;
                child = parent * 2 + 1;
            }else{
                break;
            }
        }
    }
    public void swap(Object[] elem,int x, int y){
        T tmp = (T)elem[x];
        elem[x] = elem[y];
        elem[y] = tmp;
    }
    public void push(T val){
        if(isFull()){
            elem = Arrays.copyOf(elem,elem.length * 2);
        }
        elem[usedSize] = val;
        //插入元素使用向上调整
        shiftUp(usedSize);
        usedSize++;
    }

    private void shiftUp(int child) {
        int parent = (child - 1) / 2;
        while(parent >= 0){
            if(((T)elem[child]).compareTo((T)elem[parent]) > 0){
                swap(elem, child, parent);
                child = parent;
                parent = (child - 1) / 2;
            }else{
                break;
            }
        }
    }
    public void display(){
        for (int i = 0; i < usedSize; i++) {
            System.out.print(elem[i] + " ");
        }
        System.out.println();
    }
    public boolean isFull(){
        if(elem.length == usedSize){
            return true;
        }
        return false;
    }
    public T poll(){
        T val = (T) elem[0];
        swap(elem, 0, usedSize - 1);
        //将元素置换位置后进行向下调整
        shiftDown(0 , usedSize - 1);
        usedSize--;
        return val;
    }
}
