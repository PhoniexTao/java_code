package ioperations;

import book.Book;
import book.BookList;

import java.util.Scanner;

public class BorrowOperation implements IOperations {
    public void work(BookList bookList){
        System.out.println("借阅图书");

        Scanner scanner = new Scanner(System.in);
        System.out.println("请输入你借阅的书名");
        String name = scanner.nextLine();

        int size = bookList.getUsedSize();

        for (int i = 0; i < size; i++) {
            Book book = bookList.getBook(i);
            if(book.getName().equals(name)){
                if(book.isBorrowed() == true){
                    System.out.println("这本书已经被借出了");
                    return;
                }

                book.setBorrowed(true);
                System.out.println("借阅成功");
                return;
            }
        }
        System.out.println("没有你要借阅的这本书");
    }
}
