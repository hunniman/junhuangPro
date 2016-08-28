package com.junhuang.market.core.utils;

import org.apache.commons.lang3.time.DateUtils;

import java.text.ParseException;

/**
 * Created by oyhk on 16/3/7.
 */
public class RDateUtils extends DateUtils {

    public static final String parsePattern = "yyyy-MM-dd HH:mm:ss";


    /**
     * 判读字符串是否符合日期格式
     * true:是 false:否
     * @param dateText
     * @param parsePattern
     * @return
     */
    public static boolean isDate(String dateText, String parsePattern) {
        try {
            DateUtils.parseDate(dateText, parsePattern);
        } catch (ParseException e) {
            return false;
        }
        return true;
    }

    /**
     * 判读字符串是否符合日期格式
     * true:是 false:否
     * @param dateText
     * @return
     */
    public static boolean isDate(String dateText) {
        return isDate(dateText, parsePattern);
    }


}
