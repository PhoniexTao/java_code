package Network;

import java.io.IOException;
import java.net.SocketException;
import java.util.HashMap;


public class UdpDictServer extends UdpEchoServer{

    private HashMap<String,String> dict = new HashMap<>();
    public UdpDictServer(int port) throws SocketException {
        super(port);

        //初始化词典
        dict.put("猫","cat");
        dict.put("狗","dog");
        dict.put("兔子","rabbit");
        dict.put("鸭子","duck");
    }

    @Override
    public String process(String request){
//        查字典
        return dict.getOrDefault(request, "未找到该词条");
    }

    public static void main(String[] args) throws IOException {
        UdpEchoServer server = new UdpEchoServer(9090);
        server.start();
    }
}
