package com.session;

import com.config.Configuration;
import com.executor.Executor;
import com.mapper.MapperData;
import com.mapper.MapperProxy;

import java.lang.reflect.Proxy;

/**
 * Created by sc on 2018/11/12.
 */
public class SqlSession {

    private Configuration configuration;
    private Executor executor;

    public SqlSession(Configuration configuration, Executor executor) {
        this.configuration = configuration;
        this.executor = executor;
    }

    public <T>T getMapper(Class<T> clazz){
        return (T) Proxy.newProxyInstance(this.getClass().getClassLoader(),new Class[]{clazz},new MapperProxy(this,clazz));
    }

    public <T>T selectOne(MapperData mapperData, Object param) throws Exception {
        return executor.query(mapperData,param);
    }

    public Configuration getConfiguration() {
        return configuration;
    }

    public void setConfiguration(Configuration configuration) {
        this.configuration = configuration;
    }

    public Executor getExecutor() {
        return executor;
    }

    public void setExecutor(Executor executor) {
        this.executor = executor;
    }
}
