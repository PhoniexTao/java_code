package com.phoniex.book.mapper;

import com.phoniex.book.model.BookInfo;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface BookMapper {
    @Insert("insert into book_info (book_name,author,count,price,publish) " +
            "values(#{bookName},#{author},#{count},#{price},#{publish})")
    Integer addBook(BookInfo bookInfo);
}
