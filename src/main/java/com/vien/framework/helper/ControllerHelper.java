package com.vien.framework.helper;

import com.vien.framework.annotation.Action;
import com.vien.framework.bean.Handler;
import com.vien.framework.bean.Request;
import com.vien.framework.util.ArrayUtil;
import com.vien.framework.util.CollectionUtil;

import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/**
 * Created by Shavien on 2016/12/12.^_^
 *
 * @author Vien
 * @version 1.0
 * @des 控制器助手类
 */
public final class ControllerHelper {
    //用于存放请求request 与处理器 handler的映射关系 Action Map
    private static final Map<Request, Handler> ACTION_MAP = new HashMap<Request, Handler>();

    /**
     * @des 获取Handler
     */
    public static Handler getHandler(String requestMethod, String requestPath) {
        Request request = new Request(requestMethod, requestPath);
        return getHandler(request);
    }

    public static Handler getHandler(Request request) {
        return ACTION_MAP.get(request);
    }

    static {
        //获取所有 Controller 类
        Set<Class<?>> controllerClassSet = ClassHelper.getControllerClassSet();
        if (CollectionUtil.isNotEmpty(controllerClassSet)) {
            //遍历 Controller类 set
            for (Class<?> controllerClz : controllerClassSet) {
                //获取类方法
                Method[] methods = controllerClz.getDeclaredMethods();//声明方法不包括继承的 但包括实现的
                if (ArrayUtil.isNotEmpty(methods)) {
                    //遍历方法
                    for (Method method : methods) {
                        //查找 Action注解
                        if (method.isAnnotationPresent(Action.class)) {
                            //获取 Action注解
                            Action action = method.getAnnotation(Action.class);
                            //获取 注解中value -> URL 映射规则
                            String mapping = action.value();
                            //验证 URL 映射规则 合法性
                            if (mapping.matches("\\w+:/\\w*")) {
                                String[] array = mapping.split(":");
                                if (ArrayUtil.isNotEmpty(array) && array.length == 2) {
                                    //获取请求方法和请求路径
                                    String requestMethod = array[0];
                                    String requestPath = array[1];
                                    //封装request对象
                                    Request request = new Request(requestMethod, requestPath);
                                    //封装handler对象
                                    Handler handler = new Handler(controllerClz, method);
                                    //装入 Action Map
                                    ACTION_MAP.put(request, handler);
                                }
                            }
                        }
                    }
                }
            }
        }
    }
}
