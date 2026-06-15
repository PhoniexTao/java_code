package com.phoniex.spring.demo;

import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/message")
public class MessageController {

    private List<MessageInfo> messageInfoList = new ArrayList<>();
    @PostMapping(value = "/publish", produces = "application/json")
    public String publish(@RequestBody MessageInfo messageInfo){
        if(!StringUtils.hasLength(messageInfo.getFrom())
        || !StringUtils.hasLength(messageInfo.getTo())
        || !StringUtils.hasLength(messageInfo.getMessage())){
            return "{\"ok\" : 0}";
        }
        messageInfoList.add(messageInfo);
        return  "{\"ok\" : 1}";
    }

    @GetMapping("/getList")
    public List<MessageInfo> getList(){
        return messageInfoList;
    }
}
