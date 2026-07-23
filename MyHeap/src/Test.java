import java.util.Arrays;
import java.util.List;

public class Test {
    public static void main(String[] args) {
        Integer[] array = {27, 15, 19, 18, 28, 34, 65, 49, 25, 37};
        MyHeap<Integer> heap = new MyHeap<>();
        heap.initElem(array);
        heap.creatHeap();
        heap.display();
        heap.push(80);
        heap.display();

    }
}
