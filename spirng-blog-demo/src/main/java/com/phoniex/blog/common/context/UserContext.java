package com.phoniex.blog.common.context;

public class UserContext {
    private static final ThreadLocal<Integer> CURRENT_USER_ID = new ThreadLocal<>();

    public static void setUserId(Integer userId){
        CURRENT_USER_ID.set(userId);
    }
    public static Integer getUserId(){
        return CURRENT_USER_ID.get();
    }
    public static void clear(){
        CURRENT_USER_ID.remove();
    }
}
