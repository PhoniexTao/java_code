package com.phoniex.book.controller;

import com.phoniex.book.model.BookInfo;
import com.phoniex.book.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

@RequestMapping("/book")
@RestController
public class BookController {
    @Autowired
    private BookService bookService;
    @RequestMapping("/getList")
    public List<BookInfo> getList(){
        return bookService.getList();
    }

    @RequestMapping("/addBook")
    public String addBook(BookInfo bookInfo){
        //1.参数校验
        //2.存储数据
        //3.返回结果
        if(!StringUtils.hasLength(bookInfo.getBookName())
                || !StringUtils.hasLength(bookInfo.getAuthor())
                || bookInfo.getCount() != null
                || bookInfo.getPrice() != null
                || !StringUtils.hasLength(bookInfo.getPublish())
                || bookInfo.getStatus() == null) {
            return "参数不合法";
        }
        try{
            bookService.addBook(bookInfo);
            return "";
        }catch (Exception e){
            return "添加图书发生异常：";
        }


    }

}
