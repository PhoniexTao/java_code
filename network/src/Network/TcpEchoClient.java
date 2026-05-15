package Network;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Scanner;

public class TcpEchoClient {
    private Socket socket = null;

    public TcpEchoClient(String serverIp, int serverPort) throws IOException {
        //这里可以直接把字符串的IP地址，设置进来，不需要进行转换
        // 127.0.0.1 这种字符串
        socket = new Socket(serverIp, serverPort);
    }

    public void start(){
        Scanner scanner = new Scanner(System.in);

        try (InputStream inputStream = socket.getInputStream(); OutputStream outputStream = socket.getOutputStream()) {
            //为了使用方便，这里将输入输出流套壳
            Scanner scannerNet = new Scanner(inputStream);
            PrintWriter writer = new PrintWriter(outputStream);

            //从控制台读取请求，发送给服务器
            while (true) {
                //1、从控制台读取用户输入
                String request = scanner.next();
                //2、发送给服务器(只是将数据放到发送缓冲区中，没有真正写入到网卡里）
                writer.println(request);
                //加上刷新缓冲区操作才是真正发送数据
                writer.flush();
                //3、读取服务器返回的响应
                String response = scannerNet.next();
                //4、打印到控制台
                System.out.println(response);
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        //从控制台读取请求，发送服务器

    }

    public static void main(String[] args) throws IOException {
        TcpEchoClient client = new TcpEchoClient("127.0.0.1", 9090);
        client.start();
    }
}
