package File_Operation;

import java.io.File;
import java.io.IOException;

public class Demo1 {
    public static void main(String[] args) throws IOException {
        //工作路径取决于程序运行的方式
        //1、在IDEA中直接运行，基准路径就是项目的目录
        //2、打一个jar包，单独运行jar包 ： 当前在哪个目录下执行运行命令（java-jar jar包名) 基准目录就在哪个目录
        //3、如果是打成一个war包，放到tomcat中运行，此时基准目录就是tomcat的bin目录
        //4、甚至可以通过代码中的一些api修改基准目录
        File file = new File("E:/code_c/test.txt");
//        File file = new File("./test.txt");
        System.out.println(file.getParent());
        System.out.println(file.getName());
        System.out.println(file.getPath());
        System.out.println(file.getAbsoluteFile());
        System.out.println(file.getCanonicalFile());
        
    }
}
