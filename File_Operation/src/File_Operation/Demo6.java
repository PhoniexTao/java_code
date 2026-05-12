package File_Operation;

import java.io.File;

public class Demo6 {
    public static void main(String[] args) {
        File file = new File("./test");
        File newfile = new File("./test2");
        boolean result = file.renameTo(newfile);
        System.out.println(result);
    }
}
