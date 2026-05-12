package File_Operation;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;

public class Demo9 {
    public static void main(String[] args) {
        try (Reader reader = new FileReader("./test.txt")) {

            while (true) {
                char[] buf = new char[1024];
                int n = reader.read(buf);
                if (n == -1) {
                    break;
                }
                for (int i = 0; i < n; i++) {
                    System.out.println(buf[i]);
                }
            }

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}