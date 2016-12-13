package com.vien.framework;

import com.vien.framework.helper.BeanHelper;
import com.vien.framework.helper.ClassHelper;
import com.vien.framework.helper.ControllerHelper;
import com.vien.framework.helper.IocHelper;
import com.vien.framework.util.ClassUtil;

/**
 * Created by Shavien on 2016/12/12.^_^
 * @des 初始化框架
 * 加载ClassHelper BeanHelper IocHelper ControllerHelper
 * @quthor Vien
 * @version 1.0
 */
public final class HelperLoader {
    public static void init(){
        Class<?>[] classList = {
                ClassHelper.class,
                BeanHelper.class,
                IocHelper.class,
                ControllerHelper.class
        };
        for(Class<?> clz : classList){
            ClassUtil.loadClass(clz.getName(),true);//true要初始化，而不能只链接
        }
    }
}
