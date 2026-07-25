import java.util.Comparator;

public class IntegerCP implements Comparator<Integer> {
    // 用户自己定义的比较器：直接实现Comparator接口，然后重写该接口中的compare方法即可

    @Override
    public int compare(Integer o1, Integer o2) {
        return o2 - o1;
    }
    
}
