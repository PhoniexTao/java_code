package com.phoniex.book.service;

import com.phoniex.book.dao.BookDao;
import com.phoniex.book.model.BookInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;


@Component
public class BookService {
    @Autowired
    private BookDao bookDao;
    public List<BookInfo> getList(){
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
