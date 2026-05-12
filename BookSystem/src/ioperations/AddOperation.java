package ioperations;

import book.Book;
import book.BookList;

import java.util.Scanner;

public class AddOperation implements IOperations{
    public void work(BookList bookList){
        //        判断数组是否已满
        int size = bookList.getUsedSize();
        if(size == bookList.getBooklist().length){
            System.out.println("书架满了，不能放了");
        }
        //2、构建新书对象
        System.out.println("新增图书");
        Scanner scanner = new Scanner(System.in);
        System.out.println("请输入书名：");
        String name = scanner.next()    ;
        System.out.println("请输入作者");
        String author = scanner.next();
        System.out.println("请输入价格");
        int price = scanner.nextInt();
        System.out.println("请输入书的类型");
        String type = scanner.next();

        Book newbook = new Book(name,author,price,type);
        //3、判断书架有没有这本书
        for (int i = 0; i < size; i++) {
            Book book = bookList.getBook(i);
            if(book.getName().equals(newbook)){
                System.out.println("有这本书，不能新增图书");
                return;
            }
        }
        //4、插入这本书
        bookList.setBook(size,newbook);
        bookList.setUsedSize(size + 1);
        System.out.println("新增图书成功");

    }
}
