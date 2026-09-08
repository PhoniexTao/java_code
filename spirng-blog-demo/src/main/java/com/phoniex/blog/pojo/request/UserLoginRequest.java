package com.phoniex.blog.pojo.request;

import jakarta.validation.constraints.NotNull;
import lombok.Data;
import org.hibernate.validator.constraints.Length;

@Data
public class UserLoginRequest {
    @NotNull(message = "username为空")
    @Length(max = 20)
    private String userName;
    @NotNull(message = "password为空")
    @Length(min = 5,message = "密码长度不能小于5")
    private String password;
}
