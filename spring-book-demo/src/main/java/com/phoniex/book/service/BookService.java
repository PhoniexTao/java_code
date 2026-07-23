package com.phoniex.book.service;

//import com.phoniex.book.dao.BookDao;
import com.phoniex.book.enums.BookStatusEnum;
import com.phoniex.book.mapper.BookMapper;
import com.phoniex.book.model.BookInfo;
import com.phoniex.book.model.PageRequest;
import com.phoniex.book.model.ResponseResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;


@Service
public class BookService {
//    @Autowired
//    private BookDao bookDao;
    @Autowired
    private BookMapper bookMapper;
//    public List<BookInfo> getList(){
        //理应从数据库四种查询图书，但是还未学习数据库相关操作,暂且mock数据
//        List<BookInfo> bookInfos = bookDao.mockData();
        //对结果进行二次处理
//        for (BookInfo bookInfo : bookInfos) {
//            if(bookInfo.getStatus() == 1){
//                bookInfo.setStatusCN("可借阅");
//
//            }else{
//                bookInfo.setStatusCN("不可借阅");
//            }
//        }
//        return bookInfos;
//    }

    public void addBook(BookInfo bookInfo) {
        bookMapper.addBook(bookInfo);
    }
    public ResponseResult<BookInfo> getListByPage(PageRequest pageRequest){
        //1、获取总图书数
        //2、获取当前页的数据
        Integer count = bookMapper.count();

        List<BookInfo> bookInfos = bookMapper.selectBookByPage(pageRequest);
        //对结果进行二次封装
        for (BookInfo bookInfo: bookInfos){
//            if (bookInfo.getStatus() == 1){
//                bookInfo.setStatusCN("可借阅");
//            }else{
//                bookInfo.setStatusCN("不可借阅");
//            }
            bookInfo.setStatusCN(BookStatusEnum.getStatusByCode(bookInfo.getStatus()).getDesc());
        }
//        ResponseResult<BookInfo> bookInfoResponseResult = new ResponseResult<>();
//        bookInfoResponseResult.setTotal(count);
//        bookInfoResponseResult.setRecords(bookInfos);
        return new ResponseResult<>(count,bookInfos,pageRequest);
    }

    public BookInfo queryBookId(Integer bookId) {
        return bookMapper.queryBookById(bookId);
    }

    public void updateBook(BookInfo bookInfo) {
        bookMapper.updateBook(bookInfo);
    }

    public Integer batchDelete(List<Integer> ids) {
        return bookMapper.batchDelete(ids);
    }
}
