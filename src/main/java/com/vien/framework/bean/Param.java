package com.vien.framework.bean;

import com.vien.framework.util.CastUtil;

import java.util.Map;

/**
 * Created by Shavien on 2016/12/12.^_^
 * @des 请求参数对象
 * @author Vien
 */
public class Param {

    private Map<String,Object> paramMap;

    public Param(Map<String,Object> paramMap){
        this.paramMap = paramMap;
    }

    /**
     *@des 根据参数名获取long型参数值
     */
    public long getLong(String name){
        return CastUtil.castLong(paramMap.get(name));
    }

    /**
     *@des 获取所有字段信息
     */
    public Map<String,Object> getParamMap(){
        return paramMap;
    }
}
