package com.vien.framework.util;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

/**
 * Created by Shavien on 2016/12/12.^_^
 * 属性文件工具类
 */
public final class PropsUtil {
    private static final Logger LOGGER = LoggerFactory.getLogger(PropsUtil.class);

    /**
     * @param fileName 属性文件名
     * @return Properties
     * @des 加载属性文件
     * @author Vien
     */
    public static Properties loadProps(String fileName) {
        Properties props = null;
        InputStream is = null;
        try {
            is = Thread.currentThread().getContextClassLoader().getResourceAsStream(fileName);
            if (is == null) throw new FileNotFoundException(fileName + "file is not found");
            props = new Properties();
            props.load(is);
        } catch (IOException e) {
            LOGGER.error("load properties file failure", e);
        } finally {
            try {
                is.close();
            } catch (IOException e) {
                LOGGER.error("close input stream failure", e);
            }
        }
        return props;
    }

    /**
     * @param props 属性 key 属性名
     * @return String
     * @des 获取字符型属性(默认空字符串)
     * @author Vien
     */
    public static String getString(Properties props, String key) {
        return getString(props, key, "");
    }

    /**
     * @param props 属性 key 属性名
     * @return String
     * @des 获取字符型属性(可指定默认值)
     * @author Vien
     */
    public static String getString(Properties props, String key, String defaultValue) {
        return props.getProperty(key, defaultValue);
    }

    /**
     * @param props 属性 key 属性名
     * @return int
     * @des 获取数值型属性(默认0)
     * @author Vien
     */
    public static int getInt(Properties props, String key) {
        return getInt(props, key, 0);
    }

    /**
     * @param props 属性 key 属性名
     * @return int
     * @des 获取数值型属性(可指定默认值)
     * @author Vien
     */
    public static int getInt(Properties props, String key, int defaultValue) {
        int value = defaultValue;
        if (props.containsKey(key)) {
            value = CastUtil.castInt(props.getProperty(key));
        }
        return value;
    }

    /**
     * @param props 属性 key 属性名
     * @return boolean
     * @des 获取布尔型属性(默认false)
     * @author Vien
     */
    public static boolean getBoolean(Properties props, String key) {
        return getBoolean(props, key, false);
    }

    /**
     * @param props 属性 key 属性名
     * @return boolean
     * @des 获取布尔型属性(可指定默认值)
     * @author Vien
     */
    public static boolean getBoolean(Properties props, String key, boolean defaultValue) {
        boolean value = defaultValue;
        if (props.containsKey(key)) {
            value = CastUtil.castBoolean(props.getProperty(key));
        }
        return value;
    }
}
