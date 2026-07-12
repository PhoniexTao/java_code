package com.phoniex.spring.demo.controller;

import com.phoniex.spring.demo.model.MessageInfo;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/user")
public class UserController2 {
        //即支持get，又支持post
        @RequestMapping("/m1")
        public String hello(){
            return "m1";
        }
//        只支持get
        @RequestMapping(value = "/m2",method = RequestMethod.GET)
        public String m2(){
            return "m2";
        }
        @RequestMapping(value = "/m2",method = {RequestMethod.GET,RequestMethod.POST})
        public String s3(){
            return "m3";
        }
        @GetMapping("/m4")
        public String m4(){
            return "m4";
        }
        @PostMapping("/m5")
        public String m5(){
            return "m5";
        }

        public void testLombok(){
            MessageInfo messageInfo = new MessageInfo();
            messageInfo.setMessage("");
        }
    }
