package ioperations;

import book.Book;
import book.BookList;

public class ShowOperation implements IOperations {
    public void work(BookList bookList){
        //展示需要遍历书架，遍历书架需要usedSize，所以要在bookList上提供get()set()方法
        int size = bookList.getUsedSize();
        for (int i = 0; i < size; i++) {
            //要遍历书也得拿到数组
            Book book = bookList.getBook(i);
            System.out.println(book);
        }
    }
}
