package ioperations;

import book.Book;
import book.BookList;

import java.util.Scanner;

public class FindOperation implements IOperations {

    public void work(BookList bookList){
        System.out.println("查找图书，请输入你的书名");
        Scanner scanner =new Scanner(System.in);
        String name = scanner.next();
        int size = bookList.getUsedSize();

        for (int i = 0; i < size; i++) {
            Book book = bookList.getBook(i);
            if(book.getName().equals(name)){
                System.out.println("找到了这本书");
                System.out.println(book);
                return;
            }
        }
        System.out.println("没有你要找的这本书");
    }
}
