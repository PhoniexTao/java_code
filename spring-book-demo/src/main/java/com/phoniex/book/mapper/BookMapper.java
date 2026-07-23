package com.phoniex.book.mapper;

import com.phoniex.book.model.BookInfo;
import com.phoniex.book.model.PageRequest;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import java.util.List;

@Mapper
public interface BookMapper {
    @Insert("insert into book_info (book_name,author,count,price,publish) " +
            "values(#{bookName},#{author},#{count},#{price},#{publish})")
    Integer addBook(BookInfo bookInfo);

    @Select("SELECT * FROM book_info WHERE `status` != 0 LIMIT #{offset},#{pageSize}")
    List<BookInfo> selectBookByPage(PageRequest pageRequest);

    @Select("select count(1) from book_info where `status` != 0")
    Integer count();

    @Select("select * from book_info where `status` != 0 and id = #{bookId}")
    BookInfo queryBookById(Integer bookId);


    //这里更新书籍选择动态sql
    void updateBook(BookInfo bookInfo);

    Integer batchDelete(List<Integer> ids);
}
