package ioperations;

import book.Book;
import book.BookList;

import java.util.Scanner;

public class ReturnOperation implements IOperations {
    public void work(BookList bookList){
        System.out.println("归还图书");
        Scanner scanner = new Scanner(System.in);
        System.out.println("请输入你归还的书名");
        String name = scanner.next();

        int size = bookList.getUsedSize();

        for (int i = 0; i < size; i++) {
            Book book = bookList.getBook(i);

            if(book.getName().equals(name)){
                if (book.isBorrowed()){
                    book.setBorrowed(false);
                    System.out.println("归还成功!");
                    return;
                }
            }
        }
        System.out.println("没有你要归还的图书！");
    }
}
