package com.phoniex.book;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

@RequestMapping("/book")
@RestController
public class BookController {

    @RequestMapping("/getList")
    public List<BookInfo> getList(){
        //理应从数据库四种查询图书，但是还未学习数据库相关操作,暂且mock数据
        List<BookInfo> bookInfos = mockData();
        for (BookInfo bookInfo : bookInfos) {
            if(bookInfo.getStatus() == 1){
                bookInfo.setStatusCN("可借阅");

            }else{
                bookInfo.setStatusCN("不可借阅");
            }
        }
        return bookInfos;
    }

    /**
     * mock从数据库中查询数据
     */
    public List<BookInfo> mockData(){
        List<BookInfo> bookInfos = new ArrayList<>();
        for (int i = 0; i < 15; i++) {
            BookInfo bookInfo = new BookInfo();
            bookInfo.setBookId(i);
            bookInfo.setBookName("图书" + i);
            bookInfo.setAuthor("作者" + i);
            bookInfo.setPublish("出版社 " + i);
            bookInfo.setNum(new Random(100).nextInt());//随机生成100以内的int类型的数字
            bookInfo.setPrice(new BigDecimal(new Random(100).nextInt()));
            bookInfo.setStatus(i % 5 == 0 ? 2 : 1); //1 - 可借阅  2- 不可借阅
            bookInfos.add(bookInfo);
            return bookInfos;
        }
    }
}
