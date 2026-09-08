package com.phoniex.blog.pojo.request;

import com.sun.jdi.PrimitiveValue;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
public class UpdateBlogRequest {
    @NotNull(message = "id不能为null")
    private Integer id;
    private String title;
    private String content;

}
