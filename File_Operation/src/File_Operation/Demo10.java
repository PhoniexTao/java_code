package File_Operation;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;

public class Demo10 {
    public static void main(String[] args) {
        try (InputStream inputStream = new FileInputStream("c:/appverifUI.dll")) {
            while (true) {
                int b = inputStream.read();
                if (b == -1) {
                    break;
                }
                System.out.printf("0x%x\n", b);
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}