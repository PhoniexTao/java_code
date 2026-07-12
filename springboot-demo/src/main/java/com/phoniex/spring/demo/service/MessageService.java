package com.phoniex.spring.demo.service;

import com.phoniex.spring.demo.mapper.MessageMapper;
import com.phoniex.spring.demo.model.MessageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MessageService {
    @Autowired
    private MessageMapper messageMapper;
    public void addMessage(MessageInfo messageInfo) {
        messageMapper.insertMessage(messageInfo);

    }

    public List<MessageInfo> queryAll() {
        return messageMapper.queryAll();
    }
}
