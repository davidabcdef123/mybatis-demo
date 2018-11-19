package com.plugins;

import org.apache.ibatis.plugin.Interceptor;

import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Created by sc on 2018/11/14.
 */
public class ConsumInterceptorChain {

    private final List<ConsumInterceptor> interceptorList = new ArrayList();

    public Object pluginAll(Object target){
        ConsumInterceptor consumInterceptor;
        for (int i = 0; i < interceptorList.size(); i++) {
            //使用plugin对target(handler/executor)代理包装, 此处为多次代理
            target = interceptorList.get(i).plugin(target);
        }
        return target;
    }

    public void addInterceptor(ConsumInterceptor inc){
        this.interceptorList.add(inc);
    }

    public List<ConsumInterceptor> getInterceptorList(){
        return Collections.unmodifiableList(interceptorList);
    }
}
