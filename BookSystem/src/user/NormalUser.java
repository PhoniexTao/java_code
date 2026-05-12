package user;

import book.BookList;
import ioperations.*;

import java.util.Scanner;

public class NormalUser extends User {
    IOperations[] iOperations;
    public NormalUser(String name) {
        super(name);
        iOperations = new IOperations[]{new ExitOpertaion(),new FindOperation(),new BorrowOperation(),new ReturnOperation()};
    }
    public int menu(){
        System.out.println("欢迎来到" + this.name + "的图书系统");
        System.out.println("******** 普通用户菜单 ********");
        System.out.println("1、查找图书");
        System.out.println("2、借阅图书");
        System.out.println("3、归还图书");
        System.out.println("0、退出系统");
        System.out.println("请输入你的操作：");
        Scanner scanner = new Scanner(System.in);
        int choice = scanner.nextInt();
        return choice;
    }

    public void doIoperation(int choice,BookList bookList){
        iOperations[choice].work(bookList);
    }
}
