package com.vien.framework.util;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;

/**
 * Created by Shavien on 2016/12/12.^_^
 * @des 流操作工具类
 * @author Vien
 * @verison 1.0
 */
public final class StreamUtil {
    private final static Logger LOGGER = LoggerFactory.getLogger(StreamUtil.class);

    /**
     * @des 从输入流获取 字符串
     * */
    public static String getString (InputStream is){
        StringBuilder sb = new StringBuilder();
        try{
            BufferedReader reader = new BufferedReader(new InputStreamReader(is));
            String line;
            while ((line = reader.readLine())!=null)
                sb.append(line);
        } catch (Exception e){
            LOGGER.error("get string failure",e);
            throw new RuntimeException(e);
        }
        return sb.toString();
    }
}
