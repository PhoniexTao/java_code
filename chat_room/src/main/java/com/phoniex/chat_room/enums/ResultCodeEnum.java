package com.phoniex.chat_room.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
public enum  ResultCodeEnum {
    SUCCESS(200),
    FAIL(-1);
    @Getter
    private Integer code;

}
