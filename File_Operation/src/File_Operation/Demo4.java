package File_Operation;

import java.io.File;
import java.util.Arrays;

public class Demo4 {
    public static void main(String[] args) {
        File file = new File("./");
        String[] list = file.list();
        System.out.println(Arrays.toString(list));
        File[] files = file.listFiles(); //返回的file对象包含更多的操作，不仅仅是文件名
        System.out.println(Arrays.toString(files));
    }
}
