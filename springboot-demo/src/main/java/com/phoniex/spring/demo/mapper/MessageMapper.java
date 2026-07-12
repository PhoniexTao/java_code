package com.phoniex.spring.demo.mapper;

import com.phoniex.spring.demo.model.MessageInfo;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface MessageMapper {
    /**
     * 查询所有留言信息
     *
     * @return
     */
    @Select("select * from message_info where delete_flag=0")
    List<MessageInfo> queryAll();

    /**
     *  发表留言
     */
    @Insert("insert into message_info (`from`,`to`,message) values (#{from},#{to},#{message })")
    Integer insertMessage(MessageInfo messageInfo) ;
}
