package ioperations;

import book.Book;
import book.BookList;

import java.util.Scanner;

public class DelOperations implements IOperations {
    public void work(BookList bookList){
        System.out.println("删除图书");

        Scanner scanner = new Scanner(System.in);
        System.out.println("请输入要删除的书名");
        String name = scanner.next();
        int size = bookList.getUsedSize();

        int pos = -1;
        int i = 0;
        for (; i < size ; i++) {
            if (bookList.getBook(i).equals(name)){
                System.out.println("找到了这本书");
                pos = i;
                break;
            }
        }
        if(pos == size){
            System.out.println("没有要删除的书");
            return;
        }
        //这里开始删除
        for (int j = pos; j < size - 1; j++) {
            //java中只有数组才能用下标
            //bookList.getBooklist()[j] = bookList.getBooklist()[j + 1];
            Book book = bookList.getBook(j + 1);
            bookList.setBook(j,book);
        }
        bookList.setUsedSize(size - 1);
    }
}
