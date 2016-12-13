package com.vien.framework.util;

import org.apache.commons.lang3.StringUtils;

/**
 * Created by Shavien on 2016/12/12.^_^
 *
 * @dea 字符串工具类
 */
public final class StringUtil {
    /**
     * @des 判断字符串是否为空
     */
    public static boolean isEmpty(String str) {
        if (str != null) {
            str = str.trim();
        }
        return StringUtils.isEmpty(str);
    }

    /**
     * @des 判断字符串是否非空
     */
    public static boolean isNotEmpty(String str) {
        return !isEmpty(str);
    }
    /**
     * @des 分割字符串返回字符串数组
     */
    public static String[] splitString(String str,String sep){
        return StringUtils.split(str, sep);
    }
}
