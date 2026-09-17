package com.phoniex.chat_room.model;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
public class UserInfo {
    @TableId(type = IdType.AUTO)
    private int userId;
    private String userName;
    private String password;
}
