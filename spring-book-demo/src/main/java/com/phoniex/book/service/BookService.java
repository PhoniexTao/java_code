package com.phoniex.book.service;

import com.phoniex.book.dao.BookDao;
import com.phoniex.book.mapper.BookMapper;
import com.phoniex.book.model.BookInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;


@Service
public class BookService {
    @Autowired
    private BookDao bookDao;
    @Autowired
    private BookMapper bookMapper;
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

    public void addBook(BookInfo bookInfo) {
        bookMapper.addBook(bookInfo);
    }
}
