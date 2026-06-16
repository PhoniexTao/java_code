package com.phoniex.book.service;

import com.phoniex.book.dao.BookDao;
import com.phoniex.book.model.BookInfo;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

public class BookService {
    public List<BookInfo> getList(){
        BookDao bookDao = new BookDao();
        //理应从数据库四种查询图书，但是还未学习数据库相关操作,暂且mock数据
        List<BookInfo> bookInfos = bookDao.mockData();
        //对结果进行二次处理
        for (BookInfo bookInfo : bookInfos) {
            if(bookInfo.getStatus() == 1){
                bookInfo.setStatusCN("可借阅");

            }else{
                bookInfo.setStatusCN("不可借阅");
            }
        }
        return bookInfos;
    }
}
