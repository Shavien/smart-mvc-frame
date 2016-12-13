package com.vien.framework.util;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.net.URLDecoder;
import java.net.URLEncoder;

/**
 * Created by Shavien on 2016/12/12.^_^
 *
 * @author Vien
 * @version 1.0
 * @des 编码与解码工具类
 */
public final class CodecUtil {
    private final static Logger LOGGER = LoggerFactory.getLogger(ClassUtil.class);

    /**
     * @des 将 URL 编码 utf-8
     */
    public static String encodeURL(String source) {
        String target;
        try {
            target = URLEncoder.encode(source, "utf-8");
        } catch (Exception e) {
            LOGGER.error("encode url failure", e);
            throw new RuntimeException(e);
        }
        return target;
    }

    /**
     * @des 将 URL 解码 utf-8
     */
    public static String decodeURL(String source) {
        String target;
        try {
            target = URLDecoder.decode(source, "utf-8");
        } catch (Exception e) {
            LOGGER.error("decode url failure", e);
            throw new RuntimeException(e);
        }
        return target;
    }
}
