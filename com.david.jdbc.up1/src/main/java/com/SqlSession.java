package com;

import java.lang.reflect.Proxy;

/**
 * Created by sc on 2018/11/11.
 */
public class SqlSession {

    private Executor executor=new SimpleExecutor();

    //todo configuration

    public <T> T selectOne(String sql,Object paramter){
        return executor.query(sql, paramter);
    }

    public <T>T getMapper(Class clazz){
        return (T) Proxy.newProxyInstance(this.getClass().getClassLoader(),new Class[]{clazz},new MapperProxy(clazz,this));

    }
}
