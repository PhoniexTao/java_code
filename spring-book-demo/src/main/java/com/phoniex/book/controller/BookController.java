package com.phoniex.book.controller;

import com.phoniex.book.constant.Constants;
import com.phoniex.book.enums.BookStatusEnum;
import com.phoniex.book.enums.ResultCodeEnum;
import com.phoniex.book.model.*;
import com.phoniex.book.service.BookService;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.NoUniqueBeanDefinitionException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.swing.*;
import java.awt.print.Book;
import java.math.BigDecimal;
import java.security.PublicKey;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

@Slf4j
@RequestMapping("/book")
@RestController
public class BookController {
    @Autowired
    private BookService bookService;
//    @RequestMapping("/getList")
//    public List<BookInfo> getList(){
//        return bookService.getList();
//    }


    @RequestMapping("/addBook")
    public String addBook(BookInfo bookInfo) {
        log.info("添加图书,request:{}" + bookInfo);
        //1.参数校验
        //2.存储数据
        //3.返回结果
        if (!StringUtils.hasLength(bookInfo.getBookName())
            || !StringUtils.hasLength(bookInfo.getAuthor())
            || bookInfo.getCount() == null
            || bookInfo.getPrice() == null
            || !StringUtils.hasLength(bookInfo.getPublish())
            || bookInfo.getStatus() == null) {
            log.error("添加图书，参数不合法,request:{} ", bookInfo);
            return "参数不合法";
        }
        try {
            bookService.addBook(bookInfo);
            return "";
        } catch (Exception e) {
            log.error("添加图书异常，e: ", e);
            return "添加图书发生异常：";
        }

    }

    @RequestMapping("/getListByPage")
    public Result<BookInfo> getListBypage(PageRequest pageRequest, HttpServletRequest request) {
        /*//判断是否登录
        HttpSession session = request.getSession();
        if(session == null){
            throw new NullPointerException();
        }
        if(session.getAttribute(Constants.SESSION_USER_KEY) == null){
            return Result.unlogin();
        }
        UserInfo userInfo = (UserInfo) session.getAttribute(Constants.SESSION_USER_KEY);
        if(userInfo == null || userInfo.getId() <= 0){
            //用户未登录
            return Result.unlogin ();
        }*/

        //参数校验
        //返回数据
        ResponseResult<BookInfo> listBypage = bookService.getListByPage(pageRequest);
        return Result.success(listBypage);
    }

    @RequestMapping("/queryBookById")
    public BookInfo queryBookById(Integer bookId) {
        log.info("查询图书信息， bookId:" + bookId);
        return bookService.queryBookId(bookId);
    }

    @RequestMapping("/updateBook")
    public String updateBook(BookInfo bookInfo) {
        log.info("修改图书,bookInfo: {}", bookInfo);
        try {
            bookService.updateBook(bookInfo);
            //成功
            return "";
        } catch (Exception e) {
            log.error("修改图书发生异常，e: ", e);
            return "修改图书发生异常";
        }
    }

    @RequestMapping("/deleteBook")
    //删除只需改变status属性即可
    public String deleteBook(Integer bookId) {
        log.info("修改图书,bookId: {}", bookId);
        try {
            BookInfo bookInfo = new BookInfo();
            bookInfo.setId(bookId);
            bookInfo.setStatus(BookStatusEnum.DELETED.getCode());
            bookService.updateBook(bookInfo);
            return "";
        } catch (Exception e) {
            log.error("修改图书发生异常，e：", e);
            return "删除图书发生异常";
        }
    }

    @RequestMapping("/batchDelete")
    public boolean batchDelete(@RequestParam List<Integer> ids){
        log.info("批量删除图书,ids :{}",ids);
        try {
            bookService.batchDelete(ids);
            return true;
        }catch (Exception e){
            log.error("批量删除图书失败,e:{}",e);
            return false;
        }

    }
}
