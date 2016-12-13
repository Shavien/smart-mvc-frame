package com.vien.framework.util;

/**
 * Created by Shavien on 2016/12/12.^_^
 * 转型操作工具类
 */
public final class CastUtil {
    /**
     * @des 转为String型
     */
    public static String castString(Object obj) {
        return CastUtil.castString(obj, "");
    }

    public static String castString(Object obj, String defaultValue) {
        return obj != null ? String.valueOf(obj) : defaultValue;
    }

    /**
     * @des 转为double型
     */
    public static double castDouble(Object obj) {
        return CastUtil.castDouble(obj, 0);
    }

    public static double castDouble(Object obj, double defaultValue) {
        double doubleValue = defaultValue;
        if (obj != null) {
            String str = castString(obj);
            if(StringUtil.isNotEmpty(str)){
                try{
                    doubleValue = Double.parseDouble(str);
                }catch(NumberFormatException e){
                    doubleValue = defaultValue;
                }
            }
        }
        return doubleValue;
    }
    /**
     *@des 转为long型
     */
    public static long castLong(Object obj) {
        return CastUtil.castLong(obj, 0);
    }

    public static long castLong(Object obj, long defaultValue) {
        long longValue = defaultValue;
        if (obj != null) {
            String str = castString(obj);
            if(StringUtil.isNotEmpty(str)){
                try{
                    longValue = Long.parseLong(str);
                }catch(NumberFormatException e){
                    longValue = defaultValue;
                }
            }
        }
        return longValue;
    }
    /**
     *@des 转为int型
     */
    public static int castInt(Object obj) {
        return CastUtil.castInt(obj, 0);
    }

    public static int castInt(Object obj, int defaultValue) {
        int intValue = defaultValue;
        if (obj != null) {
            String str = castString(obj);
            if(StringUtil.isNotEmpty(str)){
                try{
                    intValue = Integer.parseInt(str);
                }catch(NumberFormatException e){
                    intValue = defaultValue;
                }
            }
        }
        return intValue;
    }
    /**
     *@des 转为boolean型
     */
    public static boolean castBoolean(Object obj) {
        return CastUtil.castBoolean(obj, false);
    }

    public static boolean castBoolean(Object obj, boolean defaultValue) {
        boolean booleanValue = defaultValue;
        if (obj != null) {
            String str = castString(obj);
            if(StringUtil.isNotEmpty(str)){
                try{
                    booleanValue = Boolean.parseBoolean(str);
                }catch(NumberFormatException e){
                    booleanValue = defaultValue;
                }
            }
        }
        return booleanValue;
    }
}
