package com.vien.framework.util;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.lang.reflect.Field;
import java.lang.reflect.Method;

/**
 * Created by Shavien on 2016/12/12.^_^
 * @des 反射工具类
 * @author Vien
 * @version 1.0
 */
public final class ReflectionUtil {
    private static final Logger LOGGER = LoggerFactory.getLogger(ReflectionUtil.class);
    /**
     *@des 创建实例
     */
    public static Object newInstance(Class<?> clz){
        Object instance;
        try{
            instance = clz.newInstance();
        }catch (Exception e){
            LOGGER.error("new instance failure",e);
            throw new RuntimeException(e);
        }
        return instance;
    }
    /**
     * @des 利用反射机制 调用方法
     * @param obj 对象
     * @param method 方法
     * @param args 方法参数
     * */
    public static Object invokeMethod(Object obj, Method method, Object... args){
        Object result;
        try{
            method.setAccessible(true);//跳过 访问检查
            result = method.invoke(obj,args);
        }catch (Exception e){
            LOGGER.error("invoke method failure",e);
            throw new RuntimeException(e);
        }
        return result;
    }
    /**
     * @des 设置成员变量的值
     * @param obj 对象
     * @param  field 属性
     * @param  value 值
     * */
    public static void setFiled(Object obj,Field field,Object value){
        try{
            field.setAccessible(true);
            field.set(obj,value);
        }catch (Exception e){
            LOGGER.error("set field failure",e);
            throw new RuntimeException(e);
        }
    }
}
