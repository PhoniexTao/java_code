package com.phoniex.chat_room.request;

import lombok.Data;

@Data
public class UserLoginRequest {
    private String userName;
    private String password;
}
