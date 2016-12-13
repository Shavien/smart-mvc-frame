package com.vien.framework.helper;

import com.vien.framework.ConfigConstant;
import com.vien.framework.util.PropsUtil;

import java.util.Properties;

/**
 * Created by Shavien on 2016/12/12.^_^
 * @dea 属性文件助手类
 * @author Vien
 * @varsion 1.0
 */
public final class ConfigHelper {
    //获取属性文件
    private static final Properties CONFIG_PROPS = PropsUtil.loadProps(ConfigConstant.CONFIG_FILE);
    /**
     * @dea 获取jdbc驱动
     */
    public static String getJdbcDriver(){
        return PropsUtil.getString(CONFIG_PROPS,ConfigConstant.JDBC_DRIVER);
    }
    /**
     * @dea 获取jdbc URL
     */
    public static String getJdbcUrl(){
        return PropsUtil.getString(CONFIG_PROPS,ConfigConstant.JDBC_URL);
    }
    /**
     * @dea 获取jdbc 用户名
     */
    public static String getJdbcUsername(){
        return PropsUtil.getString(CONFIG_PROPS,ConfigConstant.JDBC_USERNAME);
    }
    /**
     * @dea 获取jdbc 密码
     */
    public static String getJdbcPassword(){
        return PropsUtil.getString(CONFIG_PROPS,ConfigConstant.JDBC_PASSWORD);
    }
    /**
     * @dea 获取应用基础包名
     */
    public static String getAppBasePath(){
        return PropsUtil.getString(CONFIG_PROPS,ConfigConstant.APP_BASE_PACKAGE);
    }
    /**
     * @dea 获取应用JSP 路径 (提供默认值)
     */
    public static String getAppJspPath(){
        return PropsUtil.getString(CONFIG_PROPS,ConfigConstant.APP_JSP_PATH,"/WEB-INF/view/");
    }
    /**
     * @dea 获取静态资源路径 html js css(提供默认值)
     */
    public static String getAppAssetPath(){
        return PropsUtil.getString(CONFIG_PROPS,ConfigConstant.APP_ASSET_PATH,"/asset/");
    }
}
