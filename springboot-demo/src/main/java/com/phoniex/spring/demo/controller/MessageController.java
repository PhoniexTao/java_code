package com.phoniex.spring.demo.controller;

import com.phoniex.spring.demo.model.MessageInfo;
import com.phoniex.spring.demo.service.MessageService;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/message")
public class MessageController {
    private MessageService messageService;
//    private List<MessageInfo> messageInfoList = new ArrayList<>();
    @PostMapping(value = "/publish", produces = "application/json")
    public String publish(@RequestBody MessageInfo messageInfo){
        if(!StringUtils.hasLength(messageInfo.getFrom())
        || !StringUtils.hasLength(messageInfo.getTo())
        || !StringUtils.hasLength(messageInfo.getMessage())){
            return "{\"ok\" : 0}";
        }
        //存储留言
        messageService.addMessage(messageInfo);
//        messageInfoList.add(messageInfo);
        return  "{\"ok\" : 1}";
    }

    @GetMapping("/getList")
    public List<MessageInfo> getList(){

        return messageService.queryAll();
    }
}
