package File_Operation;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;

public class Demo8 {
    public static void main(String[] args) {
        try (OutputStream outputStream = new FileOutputStream("./output.txt", true)) {

            // 97 在 ascii 中就是 'a'
//            outputStream.write(97);
//            outputStream.write(98);
//            outputStream.write(99);

            byte[] bytes = {99};
            outputStream.write(bytes);

        } catch (IOException e) {
            // 此处是需要处理两个异常. 由于此处并没有针对这两个异常提供不同的处理, 就直接合并了.
            throw new RuntimeException(e);
        }
    }
}