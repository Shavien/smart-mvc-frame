package com.vien.framework.helper;

import com.vien.framework.annotation.Inject;
import com.vien.framework.util.ArrayUtil;
import com.vien.framework.util.CollectionUtil;
import com.vien.framework.util.ReflectionUtil;

import java.lang.reflect.Field;
import java.util.Map;

/**
 * Created by Shavien on 2016/12/12.^_^
 */
public final class IocHelper {
    static {
        //获取Bean类与Bean实例的映射关系
        Map<Class<?>,Object> beanMap = BeanHelper.getbeanMap();
        if(CollectionUtil.isNotEmpty(beanMap)){
            //遍历bean map
            for(Map.Entry<Class<?>,Object> beanEntry : beanMap.entrySet()){
                //获取bean类与bean实例
                Class<?> beanClass = beanEntry.getKey();
                Object beanInstance = beanEntry.getValue();
                //获取Bean类定义的所有的成员变量Bean Field
                Field[] beanFields = beanClass.getDeclaredFields();
                if(ArrayUtil.isNotEmpty(beanFields)){
                    //遍历 Bean Field
                    for(Field beanField : beanFields){
                        // 判断Bean Field 是否带有Inject注解
                        if(beanField.isAnnotationPresent(Inject.class)){
                            //在 bean map 中获取 bean field对应实例
                            Class<?> beanFieldClass = beanField.getType();
                            Object beanFieldInstance = beanMap.get(beanFieldClass);
                            if(beanFieldInstance != null){
                                //反射初始化BeanField值
                                ReflectionUtil.setFiled(beanInstance,beanField,beanFieldInstance);
                            }
                        }
                    }
                }
            }
        }
    }
}
