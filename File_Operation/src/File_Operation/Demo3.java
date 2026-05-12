package File_Operation;

import java.io.File;
import java.io.IOException;
import java.sql.SQLOutput;

public class Demo3 {
    public static void main(String[] args) throws IOException, InterruptedException {
        File file = new File("./test.txt");
        file.createNewFile();
        System.out.println(file.exists());
        System.out.println(file.isFile());
//        boolean result = file.delete();
//        System.out.println(result);

        //在进程退出时删除文件
        file.deleteOnExit();
        Thread.sleep(10000);
        System.out.println(file.exists());

    }

}
