package com.phoniex.book.controller;

import com.phoniex.book.model.BookInfo;
import com.phoniex.book.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
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


}
