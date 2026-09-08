package com.phoniex.blog.common.util;

import lombok.Data;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.logging.SimpleFormatter;

@Data
public class DateUtils {
    public static String dateFormat(Date date){
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy年MM月dd日 HH:mm:ss");
        return dateFormat.format(date);
    }

}
