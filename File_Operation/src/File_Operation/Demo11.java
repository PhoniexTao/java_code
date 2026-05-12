package File_Operation;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;

public class Demo11 {
    public static void main(String[] args) {
        try (Writer writer = new FileWriter("./output.txt", true)) {
            BufferedWriter bufferedWriter = new BufferedWriter(writer);
            bufferedWriter.write("Hello World");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}