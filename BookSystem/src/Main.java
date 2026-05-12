import book.BookList;
import ioperations.IOperations;
import user.User;
import user.AdminUser;
import java.util.Scanner;
import user.NormalUser;
public class Main {
    public static User login(){
        Scanner scanner = new Scanner(System.in);
        System.out.println("请输入你的姓名：");
        String name = scanner.next();
        System.out.println("请输入你的身份：");
        System.out.println("1、管理员  2、普通用户");
        int choice = scanner.nextInt();
        if(choice == 1){
            return new AdminUser(name);
        }else{
            return new NormalUser(name);
        }
    }
    public static void main(String[] args) {
        // 1、先针对不同的用户类型来给出不同的菜单进行选择
        User user = login();
        while (true){
            int choice = user.menu();
            //2、给出菜单然，用户选择后返回选项，要针对不同的用户来判断具体的选项并且执行，只能是通过多态动态绑定实现
            BookList bookList = new BookList();
            user.doIoperation(choice,bookList);
        }




    }
}