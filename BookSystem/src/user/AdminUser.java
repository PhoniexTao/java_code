package user;

import book.BookList;
import ioperations.*;

import java.util.Scanner;

public class AdminUser extends User{
    protected IOperations[] iOperations;
    public AdminUser(String name) {
        super(name);
        iOperations = new IOperations[]{new ExitOperation(),new FindOperation(), new AddOperation(), new DelOperations(), new ShowOperation()};
    }
    public int menu(){
        System.out.println("******* 管理员菜单 ******");
        System.out.println("1、查找图书");
        System.out.println("2、新增图书");
        System.out.println("3、删除图书");
        System.out.println("4、显示图书");
        System.out.println("0、退出系统");
        System.out.println("***********************");
        Scanner scanner = new Scanner(System.in);
        System.out.println("请输入你的操作:");
        int choice = scanner.nextInt();
        return choice;
    }
    public void doIoperation(int choice,BookList bookList){
        iOperations[choice].work(bookList);

    }
}
