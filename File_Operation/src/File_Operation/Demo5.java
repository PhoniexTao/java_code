package File_Operation;

import java.io.File;

public class Demo5 {
    public static void main(String[] args) {
//        File file = new File(".test");
        File file = new File("./test/111/222/333");
        //mkdir无法创建多级目录，只能创建一级
        //boolean result = file.mkdir();

        //要创建多级目录用mkdirs();
        boolean result = file.mkdirs();
        System.out.println("result = " +     result);
    }
}
