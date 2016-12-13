package com.vien.framework.helper;

import com.vien.framework.annotation.Controller;
import com.vien.framework.annotation.Service;
import com.vien.framework.util.ClassUtil;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by Shavien on 2016/12/12.^_^
 * @des 类操作助手
 * @author Vien
 * @varsion 1.0
 */
public final class ClassHelper {
    //存放所有加载类的Set集合
    private static final Set<Class<?>> CLASS_SET;

    static {
        String basePackage = ConfigHelper.getAppBasePath();
        CLASS_SET = ClassUtil.getClassSet(basePackage);
    }

    /**
     * @des 获取应用包名下的所有类
     * */
    public static Set<Class<?>> getClassSet(){
        return CLASS_SET;
    }

    /**
     *@des 获取应用包名下的所有Service类
     */
    public static Set<Class<?>> getServiceClassSet(){
        Set<Class<?>> classSet = new HashSet<Class<?>>();
        for (Class<?> clz : CLASS_SET){
            if(clz.isAnnotationPresent(Service.class));
            classSet.add(clz);
        }
        return classSet;
    }
    /**
     *@des 获取应用包名下的所有Controller类
     */
    public static Set<Class<?>> getControllerClassSet(){
        Set<Class<?>> classSet = new HashSet<Class<?>>();
        for (Class<?> clz : CLASS_SET){
            if(clz.isAnnotationPresent(Controller.class));
            classSet.add(clz);
        }
        return classSet;
    }
    /**
     * @des 获取包名下的所有Bean(Service、Controller等)
     * */
    public static Set<Class<?>> getBeanClassSet(){
        Set<Class<?>> beanClassSet = new HashSet<Class<?>>();
        beanClassSet.addAll(getServiceClassSet());
        beanClassSet.addAll(getControllerClassSet());
        return beanClassSet;
    }
}
