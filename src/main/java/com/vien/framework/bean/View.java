package com.vien.framework.bean;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by Shavien on 2016/12/12.^_^
 * @des 视图对象 包含模型
 */
public class View {
    //视图路径
    private String path;
    //模型数据
    private Map<String,Object> model;

    public View(String path){
        this.path = path;
        model = new HashMap<String, Object>();
    }

    public View addModel(String key,Object value){
        model.put(key,value);
        return this;
    }

    public String getPath(){
        return this.path;
    }

    public Map<String,Object> getModel(){
        return this.model;
    }
}
