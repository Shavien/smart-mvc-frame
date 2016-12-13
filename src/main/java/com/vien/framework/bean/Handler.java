package com.vien.framework.bean;

import java.lang.reflect.Method;

/**
 * Created by Shavien on 2016/12/12.^_^
 * @des 处理对象 封装Action信息
 * 作为Map<Request,Handler>的value
 * @author Vien
 * @version 1.0
 */
public class Handler {
    //Controller 类
    private Class<?> controllerClass;
    //Action方法
    private Method  actionMethod;

    public Handler(Class<?> controllerClass,Method actionMethod){
        this.controllerClass = controllerClass;
        this.actionMethod = actionMethod;
    }

    public Class<?> getControllerClass(){
        return this.controllerClass;
    }

    public Method getActionMethod(){
        return this.actionMethod;
    }
}
