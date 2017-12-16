package com.sunliang.utils;

import java.util.UUID;

/**
 * @author sunliang
 * @desc uuid
 * @create 2017-12-16 11:07
 **/
public class UuidUtils {
    /**
     * 获得一个去掉“-”符号的UUID
     * @return String UUID
     */
    public static String getUUID(){
        String s = UUID.randomUUID().toString();
        //去掉“-”符号
        return s.substring(0,8)+s.substring(9,13)+s.substring(14,18)+s.substring(19,23)+s.substring(24);
    }
}
