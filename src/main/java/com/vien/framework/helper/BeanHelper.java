package com.vien.framework.helper;

import com.vien.framework.util.ReflectionUtil;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/**
 * Created by Shavien on 2016/12/12.^_^
 * @author Vien
 * @version 1.0
 * @des Bean容器
 * @des 借助ClassHelper的getBeanClassSet获取所有Bean，
 * 然后循环调用ReflectionUtil的newInstance根据类实例化对象，
 * 最后将每次创建的对象放在衣蛾静态的Map<Class<?>,Object>中。
 * 需要随时获取此Map并且通过key(类名)获取对应Value(Bean对象)
 */
public final class BeanHelper {
    //定义bean映射，存放类与实例的映射关系
    private static final Map<Class<?>, Object> BEAN_MAP = new HashMap<Class<?>, Object>();

    static {
        Set<Class<?>> beanClassSet = ClassHelper.getBeanClassSet();
        for (Class<?> beanClass : beanClassSet) {
            Object obj = ReflectionUtil.newInstance(beanClass);
            BEAN_MAP.put(beanClass, obj);
        }
    }

    /**
     * 获取Bean映射
     */
    public static Map<Class<?>, Object> getbeanMap() {
        return BEAN_MAP;
    }

    /**
     * 获取Bean实例
     */
    public static <T> T getBean(Class<T> clz) {
        if (!BEAN_MAP.containsKey(clz))
            throw new RuntimeException("can not get bean by class: " + clz);
        return (T) BEAN_MAP.get(clz);
    }

}
