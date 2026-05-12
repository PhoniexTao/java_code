package ioperations;

import book.BookList;

public class ExitOpertaion implements IOperations {
    public void work(BookList bookList){
        System.out.println("退出系统");
        System.exit(0);
    }
}
