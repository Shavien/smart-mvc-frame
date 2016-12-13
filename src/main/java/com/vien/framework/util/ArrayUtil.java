package com.vien.framework.util;

import org.apache.commons.lang3.ArrayUtils;

/**
 * Created by Shavien on 2016/12/12.^_^
 * @des 数组工具类
 * @author Vien
 * @version 1.0
 */
public final class ArrayUtil {
    /**
     *@des 判断数组是否为空
     */
    public static boolean isEmpty(Object[] array){
        return ArrayUtils.isEmpty(array);
    }
    /**
     *@des 判断数组是否非空
     */
    public static boolean isNotEmpty(Object[] array){
        return !ArrayUtils.isEmpty(array);
    }
}
